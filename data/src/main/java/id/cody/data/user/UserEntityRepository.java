package id.cody.data.user;


import id.cody.data.user.model.UserEntity;
import id.cody.data.user.model.UserinfoEntity;
import io.reactivex.rxjava3.core.Observable;

public interface UserEntityRepository {

    Observable<UserinfoEntity> login(UserEntity userEntity);
}
