package com.example.catbreedinformation.data.repository

import android.content.Context
import com.example.catbreedinformation.data.local.fake.CatBreed
import com.example.catbreedinformation.data.local.fake.FakeCatBreedDataSource

class OfflineCatBreedRepository: CatBreedRepository {
    override fun getAll(context: Context): List<CatBreed> = FakeCatBreedDataSource.getAll(context)
    override fun search(context: Context, query: String): List<CatBreed>{
        return FakeCatBreedDataSource.getAll(context).filter {
            it.name.contains(query, ignoreCase = true)
        }
    }
}


