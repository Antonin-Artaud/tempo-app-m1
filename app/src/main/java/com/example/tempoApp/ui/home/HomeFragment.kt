package com.example.tempoApp.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tempoApp.R
import com.example.tempoApp.databinding.FragmentHomeBinding
import com.example.tempoApp.helpers.ApiHelper
import com.example.tempoApp.models.CouleurJour
import com.example.tempoApp.models.NbTempDaysResponse
import com.example.tempoApp.services.api.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        loadData(binding)
        val textView: TextView = binding.dateText
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun loadData(binding: FragmentHomeBinding) {
        val call = ApiHelper.instance.create(ApiService::class.java).getNbTempoDays()
        call.enqueue(object : Callback<NbTempDaysResponse> {
            override fun onResponse(
                call: Call<NbTempDaysResponse>,
                response: Response<NbTempDaysResponse>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    Log.d("image", response.body().toString())

                    binding.JourRouge.text = "ROUGE : " + response.body()?.PARAM_NB_J_ROUGE.toString() + " / 22"
                    binding.jourBlanc.text = "BLANC : " + response.body()?.PARAM_NB_J_BLANC.toString()  + " / 43"
                    binding.jourBleu.text = "BLEU : " + response.body()?.PARAM_NB_J_BLEU.toString() + " / 300"

                    Log.d("image", response.body().toString())
                }
            }

            override fun onFailure(call: Call<NbTempDaysResponse>, t: Throwable) {
                Log.d("image", "Not yet implemented")
            }
        })

        val currentDate = LocalDate.now()
        val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val formattedDate = currentDate.format(dateFormatter)
        val call2 = ApiHelper.instance.create(ApiService::class.java).getDateDuJour(formattedDate)
        call2.enqueue(object : Callback<CouleurJour> {
            override fun onResponse(
                call: Call<CouleurJour>,
                response: Response<CouleurJour>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    Log.d("image", response.body().toString())

                    when (response.body()?.couleurJour) {
                        "TEMPO_ROUGE" -> {
                            // add red background to binding.Today
                            binding.Today.setBackgroundColor(0xFF0000)
                            binding.Today.text = "Aujourd'hui : ROUGE"
                        }
                        "TEMPO_BLANC" -> {
                            // add white background to binding.Today
                            binding.Today.setBackgroundColor(0xFFFFFF)
                            binding.Today.text = "Aujourd'hui : BLANC"
                        }
                        "TEMPO_BLEU" -> {
                            // add blue background to binding.Today
                            binding.Today.setBackgroundColor(0x0000FF)
                            binding.Today.text = "Aujourd'hui : BLEU"
                        }
                    }
                    when (response.body()?.couleurJour1) {
                        "TEMPO_ROUGE" -> {
                            // add red background to binding.JourSuivant
                            binding.JourSuivant.setBackgroundColor(0xFF0000)
                            binding.JourSuivant.text = "Demain : ROUGE"
                        }
                        "TEMPO_BLANC" -> {
                            // add white background to binding.JourSuivant
                            binding.JourSuivant.setBackgroundColor(0xFFFFFF)
                            binding.JourSuivant.text = "Demain : BLANC"
                        }
                        "TEMPO_BLEU" -> {
                            // add blue background to binding.JourSuivant
                            binding.JourSuivant.setBackgroundColor(0x0000FF)
                            binding.JourSuivant.text = "Demain : BLEU"
                        }
                    }

                    Log.d("image", response.body().toString())
                }
            }

            override fun onFailure(call: Call<CouleurJour>, t: Throwable) {
                Log.d("image", "Not yet implemented")
            }
        })
    }
}