package testapp.jccolumbres.stackoverflowapi.model;

public class TopUsers {
    private String username;
    private Integer reputation;
    private String location;
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

    public Integer getReputation() {
        return reputation;
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
