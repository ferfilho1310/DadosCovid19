package com.example.covid19.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.covid19.Model.ListDadosCovidBrazil
import com.example.covid19.Model.ListDadosCovidMundo
import com.example.covid19.Repositorys.DadosCovidBrasilActViewRepository

class ViewModelChart : ViewModel() {

    var lsDadosCovidBrasilMutableLiveData = MutableLiveData<ListDadosCovidBrazil>()
    var lsDadosCovidMundoMutableLiveData = MutableLiveData<ListDadosCovidMundo>()

    fun getDadosCovidBrasil(): MutableLiveData<ListDadosCovidBrazil> {
        lsDadosCovidBrasilMutableLiveData = DadosCovidBrasilActViewRepository.adicionarDadosGraficoPieChart()
        return lsDadosCovidBrasilMutableLiveData
    }

    fun getDadosCovidMundo() : MutableLiveData<ListDadosCovidMundo> {
        lsDadosCovidMundoMutableLiveData = DadosCovidBrasilActViewRepository.adicionarDadosGraficoPiechartMundo()
        return lsDadosCovidMundoMutableLiveData
    }

}