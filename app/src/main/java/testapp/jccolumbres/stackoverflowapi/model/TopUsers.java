package testapp.jccolumbres.stackoverflowapi.model;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

public class TopUsers {

    @SerializedName("display_name")
    private String username;

    @SerializedName("reputation")
    private Integer reputation;

    @SerializedName("location")
    private String location;

    @SerializedName("badge_counts")
    private HashMap<String, Integer> badges = new HashMap<>();

    public HashMap<String, Integer> getBadges() {
        return badges;
    }

    public void setBadges(HashMap<String, Integer> badges) {
        this.badges = badges;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getReputation() {
        return reputation;
    }

    public void setReputation(Integer reputation) {
        this.reputation = reputation;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}




