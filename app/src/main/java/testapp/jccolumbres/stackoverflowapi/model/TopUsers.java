package testapp.jccolumbres.stackoverflowapi.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

public class TopUsers implements Parcelable {

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.username);
        dest.writeValue(this.reputation);
        dest.writeString(this.location);
        dest.writeSerializable(this.badges);
    }

    public TopUsers() {
    }

    protected TopUsers(Parcel in) {
        this.username = in.readString();
        this.reputation = (Integer) in.readValue(Integer.class.getClassLoader());
        this.location = in.readString();
        this.badges = (HashMap<String, Integer>) in.readSerializable();
    }

    public static final Parcelable.Creator<TopUsers> CREATOR = new Parcelable.Creator<TopUsers>() {
        @Override
        public TopUsers createFromParcel(Parcel source) {
            return new TopUsers(source);
        }

        @Override
        public TopUsers[] newArray(int size) {
            return new TopUsers[size];
        }
    };
}




