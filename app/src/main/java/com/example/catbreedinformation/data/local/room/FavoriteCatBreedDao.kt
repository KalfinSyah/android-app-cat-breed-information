package com.example.catbreedinformation.data.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FavoriteCatBreedDao {
    @Query("SELECT * FROM favoritecatbreed")
    fun getAllData(): LiveData<List<FavoriteCatBreed>>

    @Query("SELECT * FROM favoritecatbreed WHERE id = :id")
    fun getDataById(id: Int): LiveData<FavoriteCatBreed>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(favoriteCatBreed: FavoriteCatBreed)

    @Query("DELETE FROM favoritecatbreed WHERE id = :id")
    fun delete(id: Int)
}