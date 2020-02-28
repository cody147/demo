package id.cody.demo.di;

import dagger.Component;
import id.cody.demo.ui.login.LoginActivity;

@ActivityScope
@Component(modules = LoginModule.class,dependencies = AppComponent.class)
public interface LoginComponent {

    void inject(LoginActivity loginActivity);

}
