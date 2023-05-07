package com.example.tempoApp.ui.history

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.work.ListenableWorker
import com.example.tempoApp.helpers.ApiHelper
import com.example.tempoApp.models.HistoricTempoStore
import com.example.tempoApp.services.api.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HistoryViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is history Fragment"
    }
    val text: LiveData<String> = _text


}