package com.example.covid19.Model;

import com.google.gson.annotations.SerializedName;

public class DadosCovidMundo {

    @SerializedName("country")
    private String country;
    @SerializedName("cases")
    private Integer cases;
    @SerializedName("confirmed")
    private Integer confirmed;
    @SerializedName("deaths")
    private Integer deaths;
    @SerializedName("recovered")
    private Integer recovered;
    @SerializedName("updated_at")
    private String updatedAt;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getCases() {
        return cases;
    }

    public void setCases(Integer cases) {
        this.cases = cases;
    }

    public Integer getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Integer confirmed) {
        this.confirmed = confirmed;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }


}
