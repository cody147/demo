package id.cody.demo.ui.login;

import android.content.Context;

import javax.inject.Inject;

import id.cody.domain.CaseObserver;
import id.cody.domain.login.Login;
import id.cody.domain.login.model.User;
import id.cody.domain.login.model.UserInfo;

public class LoginPresenter implements LoginContract.Presenter{


    private LoginContract.View mView;
    private Login mLogin;

    @Inject
    public LoginPresenter(LoginContract.View view, Login login, Context context){
        this.mView=view;
        this.mLogin=login;
    }

    @Override
    public void login(String username, String password) {

        User user=new User();
        user.setUsername(username);
        user.setPassword(password);

        mLogin.execute(new CaseObserver<UserInfo>(){
            @Override
            public void onNext(UserInfo userInfo) {
                super.onNext(userInfo);
                mView.loginSuccess(userInfo);
            }
        },user);



    }

    @Override
    public void onDestroy() {
        if(mLogin!=null){
            mLogin.dispose();
        }
    }
}
