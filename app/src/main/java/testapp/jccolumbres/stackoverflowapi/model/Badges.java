package testapp.jccolumbres.stackoverflowapi.model;

import com.google.gson.annotations.SerializedName;

public class Badges {

    @SerializedName("bronze")
    private Integer bronze;

    @SerializedName("silver")
    private Integer silver;

    @SerializedName("gold")
    private Integer gold;


    public Badges(Integer bronze, Integer silver, Integer gold) {
        this.setBronze(bronze);
        this.setSilver(silver);
        this.setGold(gold);
    }

    public String getBronze() {
        return bronze.toString();
    }

    public void setBronze(Integer bronze) {
        this.bronze = bronze;
    }

    public String getSilver() {
        return silver.toString();
    }

    public void setSilver(Integer silver) {
        this.silver = silver;
    }

    public String getGold() {
        return gold.toString();
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }
}
