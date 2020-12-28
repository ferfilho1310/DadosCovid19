package com.example.covid19.Util;

import android.graphics.Color;

import com.example.covid19.Model.DadosCovidBrazil;
import com.example.covid19.Model.DadosCovidMundo;
import com.example.covid19.Model.ListDadosCovidBrazil;
import com.example.covid19.Model.ListDadosCovidMundo;
import com.example.covid19.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

public class ChartUtil {

    public static void morteCovidPorPais(ListDadosCovidMundo listDadosCovidMundo, PieChart barChart){

        List<PieEntry> mortes = new ArrayList();
        PieDataSet dataSet;

        for (DadosCovidMundo dadosCovidBrazil : listDadosCovidMundo.getData()) {
            if (dadosCovidBrazil.getDeaths() >= 30000) {
                mortes.add(new PieEntry(Integer.parseInt(String.valueOf(dadosCovidBrazil.getDeaths())), dadosCovidBrazil.getCountry()));
            }
        }

        dataSet = new PieDataSet(mortes,"\n*Paises com mais de 30 mil mortes");

        dataSet.setColors(getColors());
        PieData data = new PieData(dataSet);
        barChart.setData(data);
        barChart.invalidate();
    }

    public static void morteCovidPorEstado(ListDadosCovidBrazil listDadosCovidBrazil, PieChart pieChart){
        List<PieEntry> mortes = new ArrayList();
        PieDataSet dataSet;

        for (DadosCovidBrazil dadosCovidBrazil : listDadosCovidBrazil.getDadosCovidBrazilList()) {
            if (dadosCovidBrazil.getDeaths() >= 5000) {
                mortes.add(new PieEntry(Integer.parseInt(String.valueOf(dadosCovidBrazil.getDeaths())), dadosCovidBrazil.getState()));
            }
        }

        dataSet = new PieDataSet(mortes,"\n*Estados com mais de 5 mil mortes");

        dataSet.setColors(getColors());
        PieData data = new PieData(dataSet);
        pieChart.setData(data);
        pieChart.invalidate();
    }

    public static ArrayList<Integer> getColors() {
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.rgb(156, 254, 230));
        colors.add(Color.rgb(159, 185, 235));
        colors.add(Color.rgb(143, 231, 161));
        colors.add(Color.rgb(160, 239, 136));
        colors.add(Color.rgb(200, 246, 139));
        colors.add(Color.rgb(176, 219, 233));
        colors.add(Color.rgb(183, 176, 253));
        colors.add(Color.rgb(30, 144, 255));
        colors.add(Color.rgb(176,196,222));
        colors.add(Color.rgb(0,250,154));
        colors.add(Color.rgb(152,251,152));
        colors.add(Color.rgb(60,179,113));
        colors.add(Color.rgb(128,128,128));
        colors.add(Color.rgb(105,89,205));
        colors.add(Color.rgb(72,61,139));
        colors.add(Color.rgb(65,105,225));
        colors.add(Color.rgb(0,191,255));
        return colors;
    }

    public static void configuracaoLegenda(PieChart pieChart){
        Legend legend = pieChart.getLegend();
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        legend.setFormSize(12F);
        legend.setFormToTextSpace(0f);
        legend.setTextColor(R.color.black);
        legend.setYEntrySpace(8f);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        legend.setWordWrapEnabled(true);
    }

    public static void configuracaoGrafico(PieChart pieChart, String textoCentralChart) {
        pieChart.getDescription().setEnabled(true);
        pieChart.getLegend().setEnabled(true);
        pieChart.animateY(5000);
        pieChart.notifyDataSetChanged();
        pieChart.getLegend().setWordWrapEnabled(true);
        pieChart.getLegend().setEnabled(true);
        pieChart.setCenterText(textoCentralChart);
        pieChart.setEntryLabelColor(R.color.black);
    }
}
