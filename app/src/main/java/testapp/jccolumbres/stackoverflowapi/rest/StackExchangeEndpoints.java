package testapp.jccolumbres.stackoverflowapi.rest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import testapp.jccolumbres.stackoverflowapi.model.TopUsers;

public interface StackExchangeEndpoints {


    @GET("2.2/users?pagesize=5&order=desc&sort=reputation&site=stackoverflow")
    Call<List<TopUsers>> getTopFiveUsers();
}
