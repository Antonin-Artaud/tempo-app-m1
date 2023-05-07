package com.example.tempoApp.services.api

import com.example.tempoApp.models.CouleurJour
import com.example.tempoApp.models.HistoricTempoStore
import retrofit2.Call
import retrofit2.http.GET
import com.example.tempoApp.models.NbTempDaysResponse
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("getNbTempoDays")
    fun getNbTempoDays(): Call<NbTempDaysResponse>

    @GET("searchTempoStore?&TypeAlerte=TEMPO")
    fun getDateDuJour(
        @Query("dateRelevant") dateRelevant: String
    ): Call<CouleurJour>

    @GET("historicTEMPOStore?dateBegin=2022&dateEnd=2023")
    fun getHistoricTEMPOStore(): Call<HistoricTempoStore>
}