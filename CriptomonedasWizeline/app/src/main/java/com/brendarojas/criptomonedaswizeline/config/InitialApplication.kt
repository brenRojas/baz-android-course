package com.brendarojas.criptomonedaswizeline.config

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class InitialApplication : Application() {

    companion object {
    }

    override fun onCreate() {
        super.onCreate()
        RoomModule.aplicationInstance = this
    }
}
