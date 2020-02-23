package id.cody.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class AIDLService extends Service {


    private final String TAG = "AIDLService";

    private List<Book> bookList;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"onCreate");
        bookList = new Vector<>();
        initData();
    }

    private void initData() {
//        Book book1 = new Book("活着");
//        Book book2 = new Book("或者");
//        Book book3 = new Book("叶应是叶");
//        Book book4 = new Book("https://github.com/leavesC");
//        Book book5 = new Book("http://www.jianshu.com/u/9df45b87cfdf");
//        Book book6 = new Book("http://blog.csdn.net/new_one_object");
//        bookList.add(book1);
//        bookList.add(book2);
//        bookList.add(book3);
//        bookList.add(book4);
//        bookList.add(book5);
//        bookList.add(book6);
    }


    private final BookController.Stub stub = new BookController.Stub() {

        @Override
        public List<Book> getBookList() throws RemoteException {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return bookList;
        }

        @Override
        public void addBookInOut(Book book) throws RemoteException {
            if (book != null) {
//                book.setName("服务器改了新书的名字 InOut");
                Log.d(TAG,Thread.currentThread().getName()+" 服务器接收到Book:"+book.toString());
                bookList.add(book);
            } else {
                Log.e(TAG, "接收到了一个空对象 InOut");
            }
        }

    };


    @Override
    public IBinder onBind(Intent intent) {
        return stub;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind: ");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}
