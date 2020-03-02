package id.cody.data.user;

import javax.inject.Inject;

import id.cody.data.EntityRepositoryFactory;
import id.cody.data.SourceType;
import id.cody.data.user.mock.MockUserEntityRepository;
import id.cody.data.user.network.NetworkUserEntityRepository;

public class UserEntityRepositoryFactory implements EntityRepositoryFactory<UserEntityRepository> {

    MockUserEntityRepository mockUserEntityRepository;
    NetworkUserEntityRepository networkUserEntityRepository;


    @Inject
    public UserEntityRepositoryFactory(MockUserEntityRepository mockUserEntityRepository,NetworkUserEntityRepository networkUserEntityRepository){
        this.mockUserEntityRepository=mockUserEntityRepository;
        this.networkUserEntityRepository=networkUserEntityRepository;
    }


    @Override
    public UserEntityRepository create(@SourceType String sourceType) {
        if(SourceType.mock.equals(sourceType)){
            return mockUserEntityRepository;
        }
        return networkUserEntityRepository;
    }
}
