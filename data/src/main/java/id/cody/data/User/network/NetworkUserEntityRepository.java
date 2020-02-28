package id.cody.data.User.network;

import javax.inject.Inject;

import id.cody.data.User.UserEntityRepository;
import id.cody.data.User.model.UserEntity;
import id.cody.data.User.model.UserinfoEntity;
import io.reactivex.rxjava3.core.Observable;

public class NetworkUserEntityRepository implements UserEntityRepository {

    UserNetworkApi userNetworkApi;

    @Inject
    public NetworkUserEntityRepository(UserNetworkApi networkApi){
        this.userNetworkApi= networkApi;
    }

    @Override
    public Observable<UserinfoEntity> login(UserEntity userEntity) {
        return userNetworkApi.login("","");
    }
}
