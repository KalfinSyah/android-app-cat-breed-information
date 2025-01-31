package com.example.catbreedinformation.data.local.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FavoriteCatBreed(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val imageUrl: Int,
    val origin: String,
    val lifespan: String,
    val appearance: String,
    val description: String,
)