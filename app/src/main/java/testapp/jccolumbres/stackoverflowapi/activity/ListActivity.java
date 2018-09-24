package testapp.jccolumbres.stackoverflowapi.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import testapp.jccolumbres.stackoverflowapi.R;
import testapp.jccolumbres.stackoverflowapi.adapter.UserAdapter;
import testapp.jccolumbres.stackoverflowapi.model.TopUsers;
import testapp.jccolumbres.stackoverflowapi.model.UsersReceived;
import testapp.jccolumbres.stackoverflowapi.rest.APIClient;
import testapp.jccolumbres.stackoverflowapi.rest.StackExchangeEndpoints;

public class ListActivity extends AppCompatActivity {

    TextView notifier;
    RecyclerView myRecyclerView;
    RecyclerView.Adapter myAdapter;
    List<TopUsers> dataSource = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myRecyclerView = (RecyclerView)findViewById(R.id.rvTopUsers);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new UserAdapter(dataSource,R.layout.item_layout,getApplicationContext());

        myRecyclerView.setAdapter(myAdapter);

        notifier = (TextView) findViewById(R.id.textView);
        loadUsers();

    }

    public void loadUsers(){
        StackExchangeEndpoints apiService =
                APIClient.getClient().create(StackExchangeEndpoints.class);
        Call<UsersReceived> call = apiService.getUsers("reputation","10");
        call.enqueue(new Callback<UsersReceived>() {
            @Override
            public void onResponse(Call<UsersReceived> call, Response<UsersReceived> response) {
                dataSource.clear();
                dataSource.addAll(response.body().getTopUsers());
                myAdapter.notifyDataSetChanged();
                notifier.setText("SUCCESS");
            }

            @Override
            public void onFailure(Call<UsersReceived> call, Throwable t) {
                notifier.setText("FAILED");

            }
        });

    }
}
//This is a sample change