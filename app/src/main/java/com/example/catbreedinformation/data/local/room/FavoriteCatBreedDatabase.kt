package com.example.catbreedinformation.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FavoriteCatBreed::class], version = 1)
abstract class FavoriteCatBreedDatabase: RoomDatabase() {

    abstract fun getFavoriteCatBreedDao(): FavoriteCatBreedDao

    companion object {
        @Volatile
        private var Instance: FavoriteCatBreedDatabase? = null

        fun getDatabase(context: Context): FavoriteCatBreedDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, FavoriteCatBreedDatabase::class.java, "favorite_cat_breed_database")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}