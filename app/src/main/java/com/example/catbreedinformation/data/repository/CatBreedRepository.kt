package com.example.catbreedinformation.data.repository

import android.content.Context
import com.example.catbreedinformation.data.local.fake.CatBreed

interface  CatBreedRepository {
    fun getAll(context: Context): List<CatBreed>
    fun search(context: Context, query: String): List<CatBreed>
}