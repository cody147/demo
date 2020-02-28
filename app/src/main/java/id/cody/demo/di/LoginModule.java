package id.cody.demo.di;

import dagger.Module;
import dagger.Provides;
import id.cody.demo.ui.login.LoginContract;

@Module
public class LoginModule {

    private LoginContract.View view;


    public LoginModule(LoginContract.View view){
        this.view=view;
    }

    @Provides
    @ActivityScope
    LoginContract.View provideView(){
        return this.view;
    }


}
