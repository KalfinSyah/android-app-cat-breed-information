/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.catbreedinformation.ui

import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.catbreedinformation.FavoriteCatBreedApplication
import com.example.catbreedinformation.data.repository.CatBreedRepository
import com.example.catbreedinformation.ui.screen.detail.ScreenDetailViewModel
import com.example.catbreedinformation.ui.screen.favorite.ScreenFavoriteViewModel
import com.example.catbreedinformation.ui.screen.home.ScreenHomeViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            val repository = CatBreedRepository.getInstance()
            ScreenHomeViewModel(repository = repository)
        }
        initializer {
            ScreenDetailViewModel(favoriteCatBreedApplication().container.favoriteCatBreedRepository)
        }
        initializer {
            ScreenFavoriteViewModel(favoriteCatBreedApplication().container.favoriteCatBreedRepository)
        }
    }
}

fun CreationExtras.favoriteCatBreedApplication(): FavoriteCatBreedApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as FavoriteCatBreedApplication)
