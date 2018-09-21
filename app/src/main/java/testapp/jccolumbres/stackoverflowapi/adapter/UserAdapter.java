package testapp.jccolumbres.stackoverflowapi.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import testapp.jccolumbres.stackoverflowapi.R;
import testapp.jccolumbres.stackoverflowapi.model.TopUsers;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.itemViewHolder> {
    private List<TopUsers> users;
    private int rowlayout;
    private Context ctx;

    public UserAdapter(List<TopUsers> users, int rowlayout, Context ctx) {
        this.setUsers(users);
        this.setRowlayout(rowlayout);
        this.setCtx(ctx);
    }

    public List<TopUsers> getUsers() {
        return users;
    }

    public void setUsers(List<TopUsers> users) {
        this.users = users;
    }

    public int getRowlayout() {
        return rowlayout;
    }

    public void setRowlayout(int rowlayout) {
        this.rowlayout = rowlayout;
    }

    public Context getCtx() {
        return ctx;
    }

    public void setCtx(Context ctx) {
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public itemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout,parent,false);

        return new itemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull itemViewHolder holder, int position) {
        holder.username.setText(users.get(position).getUsername());
        holder.reputation.setText(users.get(position).getReputation());
        holder.location.setText(users.get(position).getLocation());
        holder.totalSilver.setText(users.get(position).getBadges().getSilver());
        holder.totalBronze.setText(users.get(position).getBadges().getBronze());
        holder.totalGold.setText(users.get(position).getBadges().getGold());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class itemViewHolder extends RecyclerView.ViewHolder{
        LinearLayout linearLayout;
        TextView username,reputation,location,totalSilver,totalBronze,totalGold;

        public itemViewHolder(View view){
            super(view);
            linearLayout = (LinearLayout) view.findViewById(R.id.llItemView);
            username = (TextView) view.findViewById(R.id.tvUsername);
            reputation = (TextView) view.findViewById(R.id.tvReputation);
            location = (TextView) view.findViewById(R.id.tvLocation);

            totalSilver = (TextView)view.findViewById(R.id.tvSilverBadges);
            totalBronze = (TextView)view.findViewById(R.id.tvBronzeBadges);
            totalGold = (TextView)view.findViewById(R.id.tvGoldBadges);
        }

    }
}
