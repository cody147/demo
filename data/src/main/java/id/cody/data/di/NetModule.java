package id.cody.data.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import id.cody.data.user.network.UserNetworkApi;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetModule {

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(){
        return new OkHttpClient.Builder().build();
    }


    @Provides
    Retrofit provideRetrofit(OkHttpClient okHttpClient){
        return new Retrofit.Builder().baseUrl("http://www.flyer.com/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }


    @Provides
    UserNetworkApi provideNetworkApi(Retrofit retrofit){
        return retrofit.create(UserNetworkApi.class);
    }



}
