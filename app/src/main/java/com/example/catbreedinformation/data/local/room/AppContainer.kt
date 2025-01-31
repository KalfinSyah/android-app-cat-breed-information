package com.example.catbreedinformation.data.local.room

import android.content.Context
import com.example.catbreedinformation.data.repository.FavoriteCatBreedRepository
import com.example.catbreedinformation.data.repository.OfflineFavoriteCatBreedRepository

interface AppContainer {
    val favoriteCatBreedRepository: FavoriteCatBreedRepository
}

class AppDataContainer(private val context: Context) : AppContainer {
    override val favoriteCatBreedRepository: FavoriteCatBreedRepository by lazy {
        OfflineFavoriteCatBreedRepository(FavoriteCatBreedDatabase.getDatabase(context).getFavoriteCatBreedDao())
    }
}
