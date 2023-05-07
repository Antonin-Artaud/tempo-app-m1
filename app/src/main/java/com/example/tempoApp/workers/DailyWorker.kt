package com.example.tempoApp.workers

import android.app.NotificationManager
import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.tempoApp.helpers.ApiHelper
import com.example.tempoApp.helpers.NotificationHelper
import com.example.tempoApp.services.api.ApiService

class DailyWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {

    private val LOGTAG = "PROUT"

    override fun doWork(): Result {
        Log.d(LOGTAG,"doWork() is called")

        val apiHelper = ApiHelper.instance.create(ApiService::class.java)
        val call = apiHelper.getNbTempoDays()
        val notif = NotificationHelper()

        return try {
            val response = call.execute() // Synchronous call
            if (response.isSuccessful) {
                Log.d(LOGTAG,"call to getNbTempoDays() succeeded")
                response.body()?.let { notif.createNotification(applicationContext, it) }
                Result.success()
            } else {
                Log.d(LOGTAG,"call to getNbTempoDays() failed")
                Result.failure()
            }
        } catch (e : Exception) {
            Log.e(LOGTAG,"call to getNbTempoDays() failed with ${e.message}")
            Result.retry()
        }
    }
}