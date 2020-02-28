package id.cody.domain;


import id.cody.domain.login.model.User;
import id.cody.domain.login.model.UserInfo;
import io.reactivex.rxjava3.core.Observable;

public interface UserRepository {


    Observable<UserInfo> login(User user);

}
