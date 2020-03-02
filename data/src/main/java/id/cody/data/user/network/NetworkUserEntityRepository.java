package id.cody.data.user.network;

import javax.inject.Inject;

import id.cody.data.user.UserEntityRepository;
import id.cody.data.user.model.UserEntity;
import id.cody.data.user.model.UserinfoEntity;
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
