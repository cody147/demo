package id.cody.demo.ui.login;

import id.cody.demo.ui.BaseContract;
import id.cody.domain.login.model.UserInfo;

public interface LoginContract {

    interface View{
        void loginSuccess(UserInfo user);
    }

    interface Presenter extends BaseContract.Presenter {
        void login(String username,String password);
    }

}
