package id.cody.data;

public interface EntityRepositoryFactory<T> {

     T create(@SourceType String sourceType);

}
