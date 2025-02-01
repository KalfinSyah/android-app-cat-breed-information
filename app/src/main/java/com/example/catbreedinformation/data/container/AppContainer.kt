package com.example.catbreedinformation.data.container

import android.content.Context
import com.example.catbreedinformation.data.local.room.favoritecatbreed.FavoriteCatBreedDatabase
import com.example.catbreedinformation.data.repository.CatBreedRepository
import com.example.catbreedinformation.data.repository.FavoriteCatBreedRepository
import com.example.catbreedinformation.data.repository.OfflineCatBreedRepository
import com.example.catbreedinformation.data.repository.OfflineFavoriteCatBreedRepository

interface AppContainer {
    val favoriteCatBreedRepository: FavoriteCatBreedRepository
    val catBreedRepository: CatBreedRepository
}

class AppDataContainer(private val context: Context) : AppContainer {

    override val favoriteCatBreedRepository: FavoriteCatBreedRepository by lazy {
        OfflineFavoriteCatBreedRepository(FavoriteCatBreedDatabase.getDatabase(context).getFavoriteCatBreedDao())
    }

    override val catBreedRepository: CatBreedRepository by lazy {
        OfflineCatBreedRepository()
    }
}
