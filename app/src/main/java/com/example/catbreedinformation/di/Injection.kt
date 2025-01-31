package com.example.catbreedinformation.di

import com.example.catbreedinformation.data.CatBreedRepository

object Injection {
    fun provideRepository(): CatBreedRepository {
        return CatBreedRepository.getInstance()
    }
}