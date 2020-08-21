package com.example.bottomnavigation.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Credit {
    @SerializedName("gem")
    @Expose
    private Integer gem = 0;
    @SerializedName("coin")
    @Expose
    private Integer coin = 0;
    @SerializedName("cash")
    @Expose
    private Integer cash = 0;
    @SerializedName("price_unit")
    @Expose
    private String priceUnit = "rial";

    public Integer getGem() {
        return gem;
    }

    public void setGem(Integer gem) {
        this.gem = gem;
    }

    public Integer getCoin() {
        return coin;
    }

    public void setCoin(Integer coin) {
        this.coin = coin;
    }

    public Integer getCash() {
        return cash;
    }

    public void setCash(Integer cash) {
        this.cash = cash;
    }

    public String getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit;
    }
}

