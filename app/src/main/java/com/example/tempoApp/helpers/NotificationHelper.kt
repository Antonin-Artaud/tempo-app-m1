package com.example.tempoApp.helpers

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import com.example.tempoApp.R
import com.example.tempoApp.models.NbTempDaysResponse

class NotificationHelper {
    companion object
        fun createNotification(context : Context, d: NbTempDaysResponse) {

            // Create notification
            val notification = NotificationCompat.Builder(context, "NOTIFICATION_CHANNEL_ID")
                .setSmallIcon(androidx.appcompat.R.drawable.btn_radio_off_mtrl)
                .setContentTitle(context.getString(R.string.notification_title))
                .setContentText(context.getString(R.string.notification_content, d.PARAM_NB_J_BLANC.toString(), d.PARAM_NB_J_BLEU.toString(), d.PARAM_NB_J_ROUGE.toString()))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build()

            // Show notification
            val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            // TODO generate unique ID
            notificationManager.notify(2023, notification)
        }
}