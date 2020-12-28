package com.example.covid19.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InitRetrofit {

    private static Retrofit retrofit = null;
    public static String URL = "https://covid19-brazil-api.now.sh/api/report/v1/";
    public static String URL_DADOS_COVID_MUNDO = "https://covid19-brazil-api.now.sh/api/report/v1/countries/";

    public static Retrofit getRetrofit(){
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        return retrofit;
    }

    public static Retrofit getRetrofitDadoMundo(){
        retrofit = new Retrofit.Builder()
                .baseUrl(URL_DADOS_COVID_MUNDO)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
