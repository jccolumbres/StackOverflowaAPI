package testapp.jccolumbres.stackoverflowapi.model;

import com.google.gson.annotations.SerializedName;

public class Badges {

    @SerializedName("")
    private Integer bronze;
    private Integer silver;
    private Integer gold;


    public Badges(Integer bronze, Integer silver, Integer gold) {
        this.setBronze(bronze);
        this.setSilver(silver);
        this.setGold(gold);
    }

    public Integer getBronze() {
        return bronze;
    }

    public void setBronze(Integer bronze) {
        this.bronze = bronze;
    }

    public Integer getSilver() {
        return silver;
    }

    public void setSilver(Integer silver) {
        this.silver = silver;
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }
}
