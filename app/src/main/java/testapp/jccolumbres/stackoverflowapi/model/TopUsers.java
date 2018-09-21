package testapp.jccolumbres.stackoverflowapi.model;

import com.google.gson.annotations.SerializedName;

public class TopUsers {

    @SerializedName("display_name")
    private String username;

    @SerializedName("reputation")
    private Integer reputation;

    @SerializedName("location")
    private String location;

    @SerializedName("badge_counts")
    private Badges badges;

    public TopUsers(String username, Integer reputation, String location, Badges badges) {
        this.setUsername(username);
        this.setReputation(reputation);
        this.setLocation(location);
        this.setBadges(badges);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getReputation() {
        return reputation.toString();
    }

    public void setReputation(Integer reputation) {
        this.reputation = reputation;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Badges getBadges() {
        return badges;
    }

    public void setBadges(Badges badges) {
        this.badges = badges;
    }
}
