package com.example.catbreedinformation.data

import android.content.Context
import com.example.catbreedinformation.R

data class CatBreed(
    val name: String,
    val imageUrl: Int,
    val origin: String,
    val lifespan: String,
    val appearance: String,
    val description: String,
)

fun getCatBreed(context: Context): List<CatBreed> {
    val catBreedsDetails = listOf(
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

    val catBreedsImages = listOf(
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

    return catBreedsDetails.mapIndexed { index, element ->
        CatBreed(
            name = element[0],
            imageUrl = catBreedsImages[index],
            origin = element[1],
            lifespan = element[2],
            appearance = element[3],
            description = element[4]
        )
    }
}