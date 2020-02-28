package id.cody.demo;

import android.app.Application;
import android.content.Context;

import id.cody.data.di.RepositoryModule;
import id.cody.data.di.NetModule;
import id.cody.demo.di.AppComponent;
import id.cody.demo.di.AppModule;
import id.cody.demo.di.DaggerAppComponent;

public class MyApplication extends Application {

    static AppComponent appComponent;


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initDaggerComponent();
    }

    private void initDaggerComponent(){
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule())
                .repositoryModule(new RepositoryModule())
                .build();
        appComponent.inject(this);
    }

    public static AppComponent provideAppComponent(){
        return appComponent;
    }


}
