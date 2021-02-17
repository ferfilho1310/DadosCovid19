package com.example.covid19.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ListDadosCovidBrazil {

    @SerializedName("data")
    List<DadosCovidBrazil> dadosCovidBrazilList = new ArrayList<>();

    public List<DadosCovidBrazil> getDadosCovidBrazilList() {
        return dadosCovidBrazilList;
    }

    public void setDadosCovidBrazilList(List<DadosCovidBrazil> dadosCovidBrazilList) {
        this.dadosCovidBrazilList = dadosCovidBrazilList;
    }
}
