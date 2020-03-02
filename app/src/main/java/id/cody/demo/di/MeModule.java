package id.cody.demo.di;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;

import dagger.Module;
import dagger.Provides;
import id.cody.demo.MyApplication;
import id.cody.demo.ui.me.MeViewModel;

@Module
public class MeModule {
    public FragmentActivity activity;

    public MeModule(FragmentActivity activity){
        this.activity=activity;
    }

    @Provides
    public MeViewModel provideMeViewModel(){
        MeViewModel meViewModel=ViewModelProviders.of(activity).get(MeViewModel.class);
        MyApplication.provideAppComponent().inject(meViewModel);
        return meViewModel;
    }

}
