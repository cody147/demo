package id.cody.demo.di;

import dagger.Component;
import id.cody.demo.ui.me.MeActivity;

@ActivityScope
@Component(modules = MeModule.class,dependencies = AppComponent.class)
public interface MeComponent {

    void inject(MeActivity meActivity);

}
