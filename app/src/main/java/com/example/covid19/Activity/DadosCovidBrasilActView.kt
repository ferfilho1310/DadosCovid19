package com.example.covid19.Activity;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.covid19.Model.ListDadosCovidBrazil;
import com.example.covid19.Model.ListDadosCovidMundo;
import com.example.covid19.R;
import com.example.covid19.Retrofit.IDadosCovidService;
import com.example.covid19.Retrofit.InitRetrofit;
import com.example.covid19.Util.ChartUtil;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DadosCovidBrasilActView extends AppCompatActivity {

    PieChart pieChart;
    PieChart pieChartDadosMundo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pieChart = findViewById(R.id.piechart);
        pieChartDadosMundo = findViewById(R.id.barchartDadosMundo);

        ChartUtil.configuracaoGrafico(pieChart, "Mortes de COVID-19 por Estado*");
        ChartUtil.configuracaoLegenda(pieChart);

        ChartUtil.configuracaoGrafico(pieChartDadosMundo, "Mortes de COVID-19 por País*");
        ChartUtil.configuracaoLegenda(pieChartDadosMundo);

        adicionarDadosGraficoPieChart();
        adicionarDadosGraficoPiechartMundo();
    }

    private void adicionarDadosGraficoPieChart() {
        IDadosCovidService iDadosCovidService = InitRetrofit.getRetrofit().create(IDadosCovidService.class);
        Call<ListDadosCovidBrazil> lsDadosCovidBrasil = iDadosCovidService.getDadosCovid(InitRetrofit.URL);

        lsDadosCovidBrasil.enqueue(new Callback<ListDadosCovidBrazil>() {
            @Override
            public void onResponse(Call<ListDadosCovidBrazil> call, Response<ListDadosCovidBrazil> response) {
                if (response.isSuccessful()) {
                    ChartUtil.morteCovidPorEstado(response.body(),pieChart);
                }
            }

            @Override
            public void onFailure(Call<ListDadosCovidBrazil> call, Throwable t) {
                Log.i("TAG", "Error ao buscar dados " + t);
            }
        });
    }

    private void adicionarDadosGraficoPiechartMundo(){
        IDadosCovidService iDadosCovidService = InitRetrofit.getRetrofitDadoMundo().create(IDadosCovidService.class);
        Call<ListDadosCovidMundo> lsDadosCovidBrasil = iDadosCovidService.getDadosCovidMundo(InitRetrofit.URL_DADOS_COVID_MUNDO);

        lsDadosCovidBrasil.enqueue(new Callback<ListDadosCovidMundo>() {
            @Override
            public void onResponse(Call<ListDadosCovidMundo> call, Response<ListDadosCovidMundo> response) {
                if (response.isSuccessful()) {
                    ChartUtil.morteCovidPorPais(response.body(),pieChartDadosMundo);
                }
            }

            @Override
            public void onFailure(Call<ListDadosCovidMundo> call, Throwable t) {
                Log.i("TAG", "Error ao buscar dados " + t);
            }
        });
    }
}