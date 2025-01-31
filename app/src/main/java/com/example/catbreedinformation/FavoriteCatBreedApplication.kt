package com.example.catbreedinformation

import android.app.Application
import com.example.catbreedinformation.data.local.room.AppContainer
import com.example.catbreedinformation.data.local.room.AppDataContainer

class FavoriteCatBreedApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}