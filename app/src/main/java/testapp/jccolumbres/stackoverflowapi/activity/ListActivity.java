package testapp.jccolumbres.stackoverflowapi.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import testapp.jccolumbres.stackoverflowapi.R;
import testapp.jccolumbres.stackoverflowapi.adapter.UserAdapter;
import testapp.jccolumbres.stackoverflowapi.model.TopUsers;

public class ListActivity extends AppCompatActivity {

    RecyclerView myRecyclerView;
    RecyclerView.Adapter myAdapter;
    List<TopUsers> dataSource = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myRecyclerView = (RecyclerView) findViewById(R.id.rvTopUsers);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new UserAdapter(dataSource,R.layout.item_layout,getApplication());
        myRecyclerView.setAdapter(myAdapter);
    }
}
