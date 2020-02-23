package id.cody.server;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;

import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "AIDL Client1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bind_service).setOnClickListener(this);
        findViewById(R.id.get_booklist).setOnClickListener(this);
        findViewById(R.id.add_book).setOnClickListener(this);
        findViewById(R.id.stop_service).setOnClickListener(this);
        findViewById(R.id.unbind_service).setOnClickListener(this);
    }


    private boolean connected = false;
    private BookController bookController;
    CountDownLatch countDownLatch = new CountDownLatch(1);
    CyclicBarrier cyclicBarrier = new CyclicBarrier(1000);
    ExecutorService threadPool= Executors.newCachedThreadPool();

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d(TAG, Thread.currentThread().getName());
            bookController = BookController.Stub.asInterface(iBinder);
            connected = true;
            countDownLatch.countDown();
            Log.d(TAG, "onServiceConnected");
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            connected = false;
            Log.d(TAG, "onServiceDisconnected");
        }
    };

    private void bindService() {
        Intent intent = new Intent();
        intent.setPackage("id.cody.server");
        intent.setAction("book");
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
        Log.d(TAG, "bindservice");
    }

    private void unBindService() {
        unbindService(connection);
        Log.d(TAG, "unbindservice");
    }

    private void stopService() {
        Intent intent = new Intent();
        intent.setPackage("id.cody.server");
        intent.setAction("book");
        stopService(intent);
        Log.d(TAG, "stop service");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bind_service:
                new Thread(() -> {
                    bindService();
                }).start();
                break;
            case R.id.get_booklist:
                new Thread(() -> {
                    try {
                        try {
                            countDownLatch.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        long startTime = System.currentTimeMillis();
                        List<Book> books = bookController.getBookList();
                        long endTime = System.currentTimeMillis();
                        Log.d(TAG, "costTime:" + (endTime - startTime));
                        Log.d(TAG, "size:"+books.size());
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }).start();
                break;
            case R.id.add_book:
                for (int i = 0; i < 1000; i++) {
                    int finalI = i;
                    threadPool.execute(() -> {
                        try {
                            try {
                                countDownLatch.await();
                                cyclicBarrier.await();
                            } catch (BrokenBarrierException e) {
                                e.printStackTrace();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            bookController.addBookInOut(new Book("cody写的书" + finalI));
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    });
                }

                break;
            case R.id.stop_service:
                stopService();
                break;
            case R.id.unbind_service:
                unBindService();
                Log.d(TAG, "解绑");
                break;
        }
    }
}
