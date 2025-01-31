package com.example.catbreedinformation.ui.screen.home

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.catbreedinformation.data.local.fake.CatBreed
import com.example.catbreedinformation.data.repository.CatBreedRepository

class ScreenHomeViewModel(
    private val repository: CatBreedRepository
): ViewModel() {
    var query by mutableStateOf("")
    private var _catBreeds = mutableListOf<CatBreed>()

    fun getAllCatBreed(context: Context): List<CatBreed> {
        return if (this.query.isNotBlank())  {
            repository.searchCatBreed(context, query)
        } else {
            repository.getAllCatBreed(context)
        }
    }

    fun searchCatBreed(context: Context, query: String) {
        this.query= query
        _catBreeds.addAll(repository.searchCatBreed(context, query))
    }
}