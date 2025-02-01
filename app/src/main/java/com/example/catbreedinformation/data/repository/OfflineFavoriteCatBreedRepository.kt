package com.example.catbreedinformation.data.repository

import com.example.catbreedinformation.data.local.room.favoritecatbreed.FavoriteCatBreed
import com.example.catbreedinformation.data.local.room.favoritecatbreed.FavoriteCatBreedDao
import kotlinx.coroutines.flow.Flow

class OfflineFavoriteCatBreedRepository(private val favoriteCatBreedDao: FavoriteCatBreedDao): FavoriteCatBreedRepository {
    override fun getAll(): Flow<List<FavoriteCatBreed>?> = favoriteCatBreedDao.getAll()
    override fun getByName(name: String): Flow<FavoriteCatBreed?> = favoriteCatBreedDao.getByName(name)
    override suspend fun insert(favoriteCatBreed: FavoriteCatBreed) = favoriteCatBreedDao.insert(favoriteCatBreed)
    override suspend fun deleteByName(name: String) = favoriteCatBreedDao.deleteByName(name)
}