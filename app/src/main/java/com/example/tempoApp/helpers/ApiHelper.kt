package com.example.tempoApp.helpers

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

class ApiHelper {
    companion object {
        const val BASE_URL = "https://particulier.edf.fr/services/rest/referentiel/"

        val instance = build()

        private fun build() : Retrofit {
            val converter = GsonConverterFactory.create()

            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC)

            val okHttpClient = OkHttpClient().newBuilder()
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(converter)
                .client(okHttpClient)
                .build()
        }
    }
}