package testapp.jccolumbres.stackoverflowapi.rest;

import retrofit2.Call;
import retrofit2.http.GET;
import testapp.jccolumbres.stackoverflowapi.model.UsersReceived;

public interface StackExchangeEndpoints {


    @GET("2.2/users?pagesize=5&order=desc&sort=reputation&site=stackoverflow")
    Call<UsersReceived> getUsers();
}
