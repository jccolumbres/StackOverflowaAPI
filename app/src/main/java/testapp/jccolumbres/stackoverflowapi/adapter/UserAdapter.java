package testapp.jccolumbres.stackoverflowapi.adapter;

import android.content.Context;
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
import testapp.jccolumbres.stackoverflowapi.model.TopUsers;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.itemViewHolder> {
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
    public void onBindViewHolder(@NonNull itemViewHolder holder, int position) {
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



    }

    @Override
    public int getItemCount() {
        return users.size();
    }


    public static class itemViewHolder extends RecyclerView.ViewHolder{
        LinearLayout linearLayout;
        TextView silverLbl,bronzeLbl,goldLbl;
        TextView username,reputation,location,totalSilver,totalBronze,totalGold;

        public itemViewHolder(View v){
            super(v);
            linearLayout = (LinearLayout)v.findViewById(R.id.llItemView);
            username = (TextView) v.findViewById(R.id.tvUsername);
            reputation = (TextView) v.findViewById(R.id.tvReputation);
            location = (TextView) v.findViewById(R.id.tvLocation);
            totalSilver = (TextView) v.findViewById(R.id.tvSilverBadges);
            totalBronze = (TextView) v.findViewById(R.id.tvBronzeBadges);
            totalGold = (TextView) v.findViewById(R.id.tvGoldBadges);

            goldLbl = (TextView) v.findViewById(R.id.tvGoldLabel);
            silverLbl = (TextView) v.findViewById(R.id.tvSilverLabel);
            bronzeLbl = (TextView) v.findViewById(R.id.tvBronzeLabel);

        }
    }
}
