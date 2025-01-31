package com.example.catbreedinformation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.catbreedinformation.data.repository.CatBreedRepository
import com.example.catbreedinformation.ui.screen.home.ScreenHomeViewModel

class ViewModelFactory(private val repository: CatBreedRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ScreenHomeViewModel::class.java)) {
            return ScreenHomeViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}