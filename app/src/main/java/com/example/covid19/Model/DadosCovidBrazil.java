package com.example.covid19.Model;

import com.google.gson.annotations.SerializedName;

public class DadosCovidBrazil {

    @SerializedName("uid")
    private Integer uid;
    @SerializedName("uf")
    private String uf;
    @SerializedName("state")
    private String state;
    @SerializedName("cases")
    private Integer cases;
    @SerializedName("deaths")
    private Integer deaths;
    @SerializedName("suspects")
    private Integer suspects;
    @SerializedName("refuses")
    private Integer refuses;
    @SerializedName("datetime")
    private String datetime;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getCases() {
        return cases;
    }

    public void setCases(Integer cases) {
        this.cases = cases;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public Integer getSuspects() {
        return suspects;
    }

    public void setSuspects(Integer suspects) {
        this.suspects = suspects;
    }

    public Integer getRefuses() {
        return refuses;
    }

    public void setRefuses(Integer refuses) {
        this.refuses = refuses;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
}
