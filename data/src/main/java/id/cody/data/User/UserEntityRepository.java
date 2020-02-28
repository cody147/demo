package id.cody.data.User;


import id.cody.data.User.model.UserEntity;
import id.cody.data.User.model.UserinfoEntity;
import io.reactivex.rxjava3.core.Observable;

public interface UserEntityRepository {

    Observable<UserinfoEntity> login(UserEntity userEntity);
}
