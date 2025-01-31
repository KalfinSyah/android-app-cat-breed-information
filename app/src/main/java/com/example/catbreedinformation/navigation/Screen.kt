package com.example.catbreedinformation.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Favorite : Screen("favorite")
    data object About : Screen("about")
    data object Detail : Screen("detail/{name}/{imageUrl}/{origin}/{lifespan}/{appearance}/{description}") {
        fun createRoute(
            name: String,
            imageUrl: Int,
            origin: String,
            lifespan: String,
            appearance: String,
            description: String
        ) = "detail/$name/$imageUrl/$origin/$lifespan/$appearance/$description"
    }
}