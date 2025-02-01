package com.example.catbreedinformation.data.local.fake

import android.content.Context
import com.example.catbreedinformation.R

object FakeCatBreedDataSource {
    fun getAll(context: Context): List<CatBreed> {
        val getCatBreedsDetails = listOf(
            context.resources.getStringArray(R.array.abyssinian_details),
            context.resources.getStringArray(R.array.american_shorthair_details),
            context.resources.getStringArray(R.array.birman_details),
            context.resources.getStringArray(R.array.bombay_details),
            context.resources.getStringArray(R.array.british_shorthair_details),
            context.resources.getStringArray(R.array.maine_coon_details),
            context.resources.getStringArray(R.array.persian_details),
            context.resources.getStringArray(R.array.ragdoll_details),
            context.resources.getStringArray(R.array.siamese_details),
            context.resources.getStringArray(R.array.siberian_details),
            context.resources.getStringArray(R.array.sphynx_details)
        )

        val getCatBreedsImages = listOf(
            R.drawable.abyssinian,
            R.drawable.american_shorthair,
            R.drawable.birman,
            R.drawable.bombay,
            R.drawable.british_shorthair,
            R.drawable.maine_coon,
            R.drawable.persian,
            R.drawable.ragdoll,
            R.drawable.siamese,
            R.drawable.siberian,
            R.drawable.sphynx
        )
        return getCatBreedsDetails.mapIndexed { index, element ->
            CatBreed(
                name = element[0],
                imageUrl = getCatBreedsImages[index],
                origin = element[1],
                lifespan = element[2],
                appearance = element[3],
                description = element[4]
            )
        }
    }
}