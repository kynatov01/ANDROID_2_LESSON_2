package com.example.android_2_lesson_2.utils

import android.content.Context
import android.content.SharedPreferences

object PrefernceHelper {
    private lateinit var sharedPreferences: SharedPreferences

    fun unit(context: Context) {
        sharedPreferences = context.getSharedPreferences("settings", Context.MODE_PRIVATE)
    }

    var saveFragment: Boolean
        get() = sharedPreferences.getBoolean("key", false)
        set(value) = sharedPreferences.edit().putBoolean("key", value).apply()

}