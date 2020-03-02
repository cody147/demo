package id.cody.data.di;

import dagger.Module;
import dagger.Provides;
import id.cody.data.user.UserDataRepository;
import id.cody.domain.UserRepository;

@Module
public class RepositoryModule {

    @Provides
    UserRepository provideUserRepository(UserDataRepository userDataRepository){
        return userDataRepository;
    }

}
