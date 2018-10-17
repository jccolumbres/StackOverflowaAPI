package testapp.jccolumbres.stackoverflowapi.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import testapp.jccolumbres.stackoverflowapi.R;
import testapp.jccolumbres.stackoverflowapi.activity.DetailActivity;
import testapp.jccolumbres.stackoverflowapi.model.TopUsers;
import testapp.jccolumbres.stackoverflowapi.model.UsersReceived;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.itemViewHolder> {
    public static final String ITEM_KEY = "item_key";
    private List<TopUsers> users;
    private int rowLayout;
    private Context ctx;


    public UserAdapter(List<TopUsers> users, int rowLayout, Context ctx) {
        this.setUsers(users);
        this.setRowLayout(rowLayout);
        this.setCtx(ctx);
    }

    public List<TopUsers> getUsers() {
        return users;
    }

    public void setUsers(List<TopUsers> users) {
        this.users = users;
    }

    public int getRowLayout() {
        return rowLayout;
    }

    public void setRowLayout(int rowLayout) {
        this.rowLayout = rowLayout;
    }

    public Context getCtx() {
        return ctx;
    }

    public void setCtx(Context ctx) {
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public itemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(rowLayout,viewGroup,false);
        return new itemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final itemViewHolder holder, int position) {
        holder.username.setText(users.get(position).getUsername());
        holder.reputation.setText(users.get(position).getReputation().toString());
        holder.location.setText(users.get(position).getLocation());
//        holder.totalBronze.setText(users.get(position).getBadges().getBronze());
//        holder.totalSilver.setText(users.get(position).getBadges().getSilver());
//        holder.totalGold.setText(users.get(position).getBadges().getGold());

        Iterator<Map.Entry<String,Integer>> it =
                users.get(position).getBadges().entrySet().iterator();

        Map.Entry<String,Integer> pair = it.next();
        holder.silverLbl.setText(pair.getKey() + " : ");
        holder.totalSilver.setText(pair.getValue().toString());

        pair = it.next();
        holder.bronzeLbl.setText(pair.getKey() + " : ");
        holder.totalBronze.setText(pair.getValue().toString());

        pair = it.next();
        holder.goldLbl.setText(pair.getKey() + " : ");
        holder.totalGold.setText(pair.getValue().toString());

        final TopUsers topUsers = users.get(position);

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx,DetailActivity.class);
                intent.putExtra(ITEM_KEY,topUsers);
                ctx.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return users.size();
    }


    public static class itemViewHolder extends RecyclerView.ViewHolder{
        LinearLayout linearLayout;
        TextView silverLbl,bronzeLbl,goldLbl;
        TextView username,reputation,location,totalSilver,totalBronze,totalGold;
        View view;
        public itemViewHolder(View v){
            super(v);
            linearLayout = v.findViewById(R.id.llItemView);
            username = v.findViewById(R.id.tvUsername);
            reputation = v.findViewById(R.id.tvReputation);
            location = v.findViewById(R.id.tvLocation);
            totalSilver = v.findViewById(R.id.tvSilverBadges);
            totalBronze = v.findViewById(R.id.tvBronzeBadges);
            totalGold = v.findViewById(R.id.tvGoldBadges);

            goldLbl = v.findViewById(R.id.tvGoldLabel);
            silverLbl = v.findViewById(R.id.tvSilverLabel);
            bronzeLbl = v.findViewById(R.id.tvBronzeLabel);
            view = v;

        }
    }
}
