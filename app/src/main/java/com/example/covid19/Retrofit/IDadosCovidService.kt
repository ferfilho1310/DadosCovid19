package com.example.covid19.Retrofit;

import com.example.covid19.Model.ListDadosCovidMundo;
import com.example.covid19.Model.ListDadosCovidBrazil;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface IDadosCovidService {

    @GET()
    Call<ListDadosCovidBrazil> getDadosCovid(@Url String url);

    @GET()
    Call<ListDadosCovidMundo> getDadosCovidMundo(@Url String url);
}
