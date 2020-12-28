package com.example.covid19.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListDadosCovidMundo {

    @SerializedName("data")
    private List<DadosCovidMundo> data = null;

    public List<DadosCovidMundo> getData() {
        return data;
    }

    public void setData(List<DadosCovidMundo> data) {
        this.data = data;
    }

}
