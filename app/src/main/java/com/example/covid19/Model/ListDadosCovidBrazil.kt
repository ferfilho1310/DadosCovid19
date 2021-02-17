package com.example.covid19.Model

import com.google.gson.annotations.SerializedName
import java.util.*

data class ListDadosCovidBrazil (
    @SerializedName("data")
    var dadosCovidBrazilList: List<DadosCovidBrazil> = ArrayList()
)