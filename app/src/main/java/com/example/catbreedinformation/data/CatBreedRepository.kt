package com.example.catbreedinformation.data

import android.content.Context
import com.example.catbreedinformation.data.local.fake.CatBreed
import com.example.catbreedinformation.data.local.fake.FakeCatBreedDataSource

class CatBreedRepository {
    fun getAllCatBreed(context: Context) = FakeCatBreedDataSource.getAllCatBreed(context)

    fun searchCatBreed(context: Context, query: String): List<CatBreed>{
        return FakeCatBreedDataSource.getAllCatBreed(context).filter {
            it.name.contains(query, ignoreCase = true)
        }
    }

    companion object {
        @Volatile
        private var instance: CatBreedRepository? = null

        fun getInstance(): CatBreedRepository =
            instance ?: synchronized(this) {
                CatBreedRepository().apply {
                    instance = this
                }
            }
    }
}