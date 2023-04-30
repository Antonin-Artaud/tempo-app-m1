package com.example.tempoApp.services.api

import com.example.tempoApp.models.HistoricTempoStore
import retrofit2.Call
import retrofit2.http.GET
import com.example.tempoApp.models.NbTempDaysResponse

interface ApiService {
    @GET("getNbTempoDays")
    fun getNbTempoDays(): Call<NbTempDaysResponse>

    @GET("historicTEMPOStore?dateBegin=2022&dateEnd=2023")
    fun getHistoricTEMPOStore(): Call<HistoricTempoStore>
}