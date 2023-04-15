package com.example.android_2_lesson_2.utils

import android.app.Application

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        inittPref()
    }

    private fun inittPref() {
        PrefernceHelper.unit(this)
    }

}