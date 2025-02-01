package com.example.catbreedinformation.data.repository

import com.example.catbreedinformation.data.local.room.favoritecatbreed.FavoriteCatBreed
import kotlinx.coroutines.flow.Flow

interface  FavoriteCatBreedRepository {
    fun getAll(): Flow<List<FavoriteCatBreed>?>
    fun getByName(name: String): Flow<FavoriteCatBreed?>

    suspend fun insert(favoriteCatBreed: FavoriteCatBreed)
    suspend fun deleteByName(name: String)
}