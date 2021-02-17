package com.example.covid19.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object InitRetrofit {

    private var retrofit: Retrofit? = null
    var URL = "https://covid19-brazil-api.now.sh/api/report/v1/"
    var URL_DADOS_COVID_MUNDO = "https://covid19-brazil-api.now.sh/api/report/v1/countries/"

    fun getRetrofit(): Retrofit? {
        retrofit = Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit
    }

    val retrofitDadoMundo: Retrofit?
        get() {
            retrofit = Retrofit.Builder()
                    .baseUrl(URL_DADOS_COVID_MUNDO)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            return retrofit
        }
}