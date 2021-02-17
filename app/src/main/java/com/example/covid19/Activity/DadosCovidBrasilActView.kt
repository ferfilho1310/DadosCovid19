package com.example.covid19.Activity

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.covid19.R
import com.example.covid19.Util.ChartUtil
import com.example.covid19.ViewModels.ViewModelChart
import kotlinx.android.synthetic.main.activity_main.*

class DadosCovidBrasilActView : AppCompatActivity() {

    lateinit var context: Context

    lateinit var mainActivityViewModel: ViewModelChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this@DadosCovidBrasilActView

        mainActivityViewModel = ViewModelProvider(this).get(ViewModelChart::class.java)

        ChartUtil.configuracaoGrafico(piechart, "Mortes de COVID-19 por Estado*")
        ChartUtil.configuracaoLegenda(piechart)
        ChartUtil.configuracaoGrafico(barchartDadosMundo, "Mortes de COVID-19 por País*")
        ChartUtil.configuracaoLegenda(barchartDadosMundo)

        mainActivityViewModel.getDadosCovidBrasil().observe(this, {
            ChartUtil.morteCovidPorEstado(it,piechart)
        })

        mainActivityViewModel.getDadosCovidMundo().observe(this, {
            ChartUtil.morteCovidPorPais(it, barchartDadosMundo)
        })
    }
}