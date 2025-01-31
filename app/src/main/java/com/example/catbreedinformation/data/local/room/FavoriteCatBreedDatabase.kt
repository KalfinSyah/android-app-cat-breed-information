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
        private var INSTANCE: FavoriteCatBreedDatabase? = null
        @JvmStatic
        fun getDatabase(context: Context): FavoriteCatBreedDatabase {
            if (INSTANCE == null) {
                synchronized(FavoriteCatBreedDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        FavoriteCatBreedDatabase::class.java,
                        "favorite_cat_breed_database"
                    ).build()
                }
            }
            return INSTANCE as FavoriteCatBreedDatabase
        }
    }
}