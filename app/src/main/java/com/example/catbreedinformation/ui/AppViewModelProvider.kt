package com.example.catbreedinformation.ui

import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.catbreedinformation.MainApplication
import com.example.catbreedinformation.ui.screen.detail.ScreenDetailViewModel
import com.example.catbreedinformation.ui.screen.favorite.ScreenFavoriteViewModel
import com.example.catbreedinformation.ui.screen.home.ScreenHomeViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            ScreenHomeViewModel(mainApplication().container.catBreedRepository)
        }
        initializer {
            ScreenDetailViewModel(mainApplication().container.favoriteCatBreedRepository)
        }
        initializer {
            ScreenFavoriteViewModel(mainApplication().container.favoriteCatBreedRepository)
        }
    }
}

fun CreationExtras.mainApplication(): MainApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as MainApplication)
