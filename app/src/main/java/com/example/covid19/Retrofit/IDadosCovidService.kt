package com.example.covid19.Retrofit

import retrofit2.http.GET
import retrofit2.http.Url
import com.example.covid19.Model.ListDadosCovidBrazil
import com.example.covid19.Model.ListDadosCovidMundo
import retrofit2.Call

interface IDadosCovidService {
    @GET
    fun getDadosCovid(@Url url: String?): Call<ListDadosCovidBrazil?>?

    @GET
    fun getDadosCovidMundo(@Url url: String?): Call<ListDadosCovidMundo?>?
}