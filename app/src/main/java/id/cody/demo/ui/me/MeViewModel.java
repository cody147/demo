package id.cody.demo.ui.me;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;

import javax.inject.Inject;

import id.cody.demo.MyApplication;
import id.cody.demo.ui.BaseViewModel;
import id.cody.demo.ui.binding.command.BindingAction;
import id.cody.demo.ui.binding.command.BindingCommand;
import id.cody.domain.CaseObserver;
import id.cody.domain.login.Login;
import id.cody.domain.login.model.User;
import id.cody.domain.login.model.UserInfo;

public class MeViewModel extends BaseViewModel {

    public static final String TAG ="MeViewModel";

    @Inject
    Login login;

    @Inject
    Context context;


    public UserInfoModel userInfoModel = new UserInfoModel();

    public MeViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    public void inject(){
        MyApplication.provideAppComponent().inject(this);
    }

    public BindingCommand loginOnClickCommand=new BindingCommand(new BindingAction() {
        @Override
        public void call() {

        }
    });


    public View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            login();
        }
    };

    private void login(){
        login.execute(new CaseObserver<UserInfo>() {
            @Override
            public void onNext(UserInfo userInfo) {
                super.onNext(userInfo);
                userInfoModel.setAge(""+userInfo.age);
                Log.d(TAG, "age:" + userInfo.age);
            }
        }, new User());
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        login.dispose();
    }
}
