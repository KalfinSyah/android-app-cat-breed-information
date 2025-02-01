package com.example.catbreedinformation.ui.screen.favorite

import androidx.lifecycle.ViewModel
import com.example.catbreedinformation.data.local.room.favoritecatbreed.FavoriteCatBreed
import com.example.catbreedinformation.data.repository.FavoriteCatBreedRepository
import kotlinx.coroutines.flow.Flow

class ScreenFavoriteViewModel(
    private val repository: FavoriteCatBreedRepository
): ViewModel() {
    fun getAll(): Flow<List<FavoriteCatBreed>?> {
        return repository.getAll()
    }
}