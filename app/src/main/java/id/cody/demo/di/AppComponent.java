package id.cody.demo.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import id.cody.data.user.network.UserNetworkApi;
import id.cody.data.di.RepositoryModule;
import id.cody.data.di.NetModule;
import id.cody.demo.MyApplication;
import id.cody.demo.ui.me.MeViewModel;
import id.cody.domain.UserRepository;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {AppModule.class, NetModule.class, RepositoryModule.class})
public interface AppComponent {

    void inject(MyApplication application);

    void inject(MeViewModel viewModel);

    //告诉依赖于AppComponent的Component,AppComponent能为你们提供Context对象
    Context context();

    Retrofit retrofit();

    UserNetworkApi userApi();

    UserRepository userRepository();

}
