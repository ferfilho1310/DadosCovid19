package com.example.covid19.Repositorys

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.covid19.Model.ListDadosCovidBrazil
import com.example.covid19.Model.ListDadosCovidMundo
import com.example.covid19.Retrofit.IDadosCovidService
import com.example.covid19.Retrofit.InitRetrofit
import com.example.covid19.Util.ChartUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object DadosCovidBrasilActViewRepository {

    val lsDadosCovidBrasilMLD = MutableLiveData<ListDadosCovidBrazil>()
    val lsDadosCovidMundoMLD = MutableLiveData<ListDadosCovidMundo>()

    fun adicionarDadosGraficoPieChart(): MutableLiveData<ListDadosCovidBrazil> {
        val iDadosCovidService = InitRetrofit.getRetrofit()?.create(IDadosCovidService::class.java)
        val lsDadosCovidBrasil = iDadosCovidService?.getDadosCovid(InitRetrofit.URL)
        lsDadosCovidBrasil?.enqueue(object : Callback<ListDadosCovidBrazil?> {
            override fun onResponse(call: Call<ListDadosCovidBrazil?>, response: Response<ListDadosCovidBrazil?>) {
                if (response.isSuccessful) {
                    lsDadosCovidBrasilMLD.value = response.body()
                }
            }

            override fun onFailure(call: Call<ListDadosCovidBrazil?>, t: Throwable) {
                Log.i("TAG", "Error ao buscar dados $t")
            }
        })
        return lsDadosCovidBrasilMLD
    }

    fun adicionarDadosGraficoPiechartMundo() : MutableLiveData<ListDadosCovidMundo> {
        val iDadosCovidService = InitRetrofit.retrofitDadoMundo?.create(IDadosCovidService::class.java)
        val lsDadosCovidBrasil = iDadosCovidService?.getDadosCovidMundo(InitRetrofit.URL_DADOS_COVID_MUNDO)
        lsDadosCovidBrasil?.enqueue(object : Callback<ListDadosCovidMundo?> {
            override fun onResponse(call: Call<ListDadosCovidMundo?>, response: Response<ListDadosCovidMundo?>) {
                if (response.isSuccessful) {
                    lsDadosCovidMundoMLD.value = response.body()
                }
            }

            override fun onFailure(call: Call<ListDadosCovidMundo?>, t: Throwable) {
                Log.i("TAG", "Error ao buscar dados $t")
            }
        })
        return lsDadosCovidMundoMLD
    }

}