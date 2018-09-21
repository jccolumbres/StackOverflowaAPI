package testapp.jccolumbres.stackoverflowapi.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UsersReceived {

    @SerializedName("items")
    private List<TopUsers> topUsers;

    public UsersReceived(List<TopUsers> topUsers) {
        this.setTopUsers(topUsers);
    }

    public List<TopUsers> getTopUsers() {
        return topUsers;
    }

    public void setTopUsers(List<TopUsers> topUsers) {
        this.topUsers = topUsers;
    }
}
