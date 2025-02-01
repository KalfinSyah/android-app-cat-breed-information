package com.example.catbreedinformation

import android.app.Application
import com.example.catbreedinformation.data.container.AppContainer
import com.example.catbreedinformation.data.container.AppDataContainer

class MainApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}