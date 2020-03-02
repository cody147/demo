package id.cody.data.user.mock;

import javax.inject.Inject;

import id.cody.data.user.UserEntityRepository;
import id.cody.data.user.model.UserEntity;
import id.cody.data.user.model.UserinfoEntity;
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
