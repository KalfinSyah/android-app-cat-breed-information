package com.example.catbreedinformation.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteCatBreedDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(favoriteCatBreed: FavoriteCatBreed)

    @Query("DELETE FROM favoritecatbreed WHERE name = :name")
    suspend fun deleteByName(name: String)

    @Query("SELECT * FROM favoritecatbreed")
     fun getAll(): Flow<List<FavoriteCatBreed>?>

     @Query("SELECT * FROM favoritecatbreed WHERE name = :name")
     fun getByName(name: String): Flow<FavoriteCatBreed?>
}