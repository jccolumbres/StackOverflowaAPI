package testapp.jccolumbres.stackoverflowapi.rest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import testapp.jccolumbres.stackoverflowapi.model.UsersReceived;

public interface StackExchangeEndpoints {


    @GET("2.2/users?&order=desc&site=stackoverflow")
    Call<UsersReceived> getUsers(@Query("sort") String sort,
                                 @Query("pagesize") String pageSize);
}
//&sort=reputation