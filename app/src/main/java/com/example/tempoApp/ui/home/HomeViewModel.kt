package com.example.tempoApp.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tempoApp.helpers.ApiHelper
import com.example.tempoApp.models.HistoricTempoStore
import com.example.tempoApp.models.NbTempDaysResponse
import com.example.tempoApp.services.api.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Date

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = Date.from(java.time.Instant.now()).toString()
    }
    val text: LiveData<String> = _text
}