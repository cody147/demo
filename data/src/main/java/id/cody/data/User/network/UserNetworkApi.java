package id.cody.data.User.network;

import id.cody.data.User.model.UserinfoEntity;
import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserNetworkApi {

    @GET("login")
    Observable<UserinfoEntity> login(@Query("username") String username, @Query("password") String password);


}
