package com.example.catbreedinformation.ui.screen.detail

import androidx.lifecycle.ViewModel
import com.example.catbreedinformation.data.local.room.favoritecatbreed.FavoriteCatBreed
import com.example.catbreedinformation.data.repository.FavoriteCatBreedRepository
import kotlinx.coroutines.flow.first

class ScreenDetailViewModel(private val repository: FavoriteCatBreedRepository): ViewModel() {
    suspend fun setAsFavorite(favoriteCatBreed: FavoriteCatBreed) {
        repository.insert(favoriteCatBreed)
    }

    suspend fun deleteFromFavorite(name: String) {
        repository.deleteByName(name)
    }

    suspend fun checkIsFavorite(name: String): Boolean {
        return repository.getByName(name)
            .first()
            .let { it != null }
    }
}