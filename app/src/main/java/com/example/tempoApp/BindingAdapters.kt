package com.example.tempoApp

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import androidx.databinding.BindingAdapter

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("android:background")
    fun setBackgroundColor(view: View, color: String) {
        view.background = ColorDrawable(Color.parseColor(color))
    }
}