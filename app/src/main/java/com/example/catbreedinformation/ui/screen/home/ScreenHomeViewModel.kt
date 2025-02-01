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

    fun getCatBreeds(context: Context): List<CatBreed> {
        return if (this.query.isNotBlank())  {
            repository.search(context, query)
        } else {
            repository.getAll(context)
        }
    }

    fun search(query: String) {
        this.query= query
    }

//    var query: String? by mutableStateOf(null)
//
//    private var _catBreeds = mutableListOf<CatBreed>()
//    val catBreeds: List<CatBreed> = _catBreeds
//
//    fun search(context: Context, query: String? = null) {
//        this.query = query
//        _catBreeds.clear()
//
//        if (query.isNullOrBlank()) {
//            _catBreeds.addAll(repository.getAll(context))
//        } else {
//            _catBreeds.addAll(repository.search(context, query))
//        }
//    }
}