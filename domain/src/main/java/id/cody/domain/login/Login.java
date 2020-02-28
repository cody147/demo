package id.cody.domain.login;

import javax.inject.Inject;

import id.cody.domain.UseCase;
import id.cody.domain.UserRepository;
import id.cody.domain.login.model.User;
import id.cody.domain.login.model.UserInfo;
import io.reactivex.rxjava3.core.Observable;

public class Login extends UseCase<User, UserInfo> {


    UserRepository userRepository;

    @Inject
    public Login(UserRepository userRepository){
        this.userRepository=userRepository;
    }


    @Override
    protected Observable<UserInfo> buildObservable(User model) {
        return userRepository.login(model);
    }
}
