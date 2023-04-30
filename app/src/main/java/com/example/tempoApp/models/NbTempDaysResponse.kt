package com.example.tempoApp.models

import com.google.gson.annotations.SerializedName

data class NbTempDaysResponse (
     @SerializedName("PARAM_NB_J_BLANC") var PARAM_NB_J_BLANC: Int? = null,
     @SerializedName("PARAM_NB_J_ROUGE") var PARAM_NB_J_ROUGE: Int? = null,
     @SerializedName("PARAM_NB_J_BLEU") var PARAM_NB_J_BLEU: Int? = null,
)