package id.cody.data.user;

import javax.inject.Inject;

import id.cody.data.SourceType;
import id.cody.data.user.model.UserEntity;
import id.cody.data.user.model.UserinfoEntity;
import id.cody.domain.UserRepository;
import id.cody.domain.login.model.User;
import id.cody.domain.login.model.UserInfo;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;

public class UserDataRepository implements UserRepository {


    private UserEntityRepositoryFactory userEntityRepositoryFactory;

    @Inject
    public UserDataRepository(UserEntityRepositoryFactory userEntityRepositoryFactory) {
        this.userEntityRepositoryFactory = userEntityRepositoryFactory;
    }

    @Override
    public Observable<UserInfo> login(User user) {
        UserEntity entity=new UserEntity();
        return mockUserEntityRepository().login(entity).map(new Function<UserinfoEntity, UserInfo>() {
            @Override
            public UserInfo apply(UserinfoEntity userinfoEntity) throws Throwable {
                Thread.sleep(2*1000);
                UserInfo userInfo=new UserInfo();
                userInfo.age=10;
                return userInfo;
            }
        });
    }

    private UserEntityRepository mockUserEntityRepository() {
        return userEntityRepositoryFactory.create(SourceType.mock);
    }
}
