package id.cody.demo.di;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module()
public class AppModule {

    Application mApplication;

    public AppModule(Application application){
        mApplication=application;
    }

    @Provides
    Context provideContext(){
        return mApplication;
    }

}
