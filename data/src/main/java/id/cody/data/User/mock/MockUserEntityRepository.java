package id.cody.data.User.mock;

import java.util.concurrent.Callable;

import javax.inject.Inject;

import id.cody.data.User.UserEntityRepository;
import id.cody.data.User.model.UserEntity;
import id.cody.data.User.model.UserinfoEntity;
import io.reactivex.rxjava3.core.Observable;

public class MockUserEntityRepository implements UserEntityRepository {

    @Inject
    public MockUserEntityRepository(){

    }

    @Override
    public Observable<UserinfoEntity> login(UserEntity userEntity) {
        return Observable.fromCallable(() -> new UserinfoEntity());
    }
}
