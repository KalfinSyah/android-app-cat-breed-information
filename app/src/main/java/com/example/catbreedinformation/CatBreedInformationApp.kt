package com.example.catbreedinformation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.catbreedinformation.navigation.Screen
import com.example.catbreedinformation.ui.components.BottomBar
import com.example.catbreedinformation.ui.screen.about.ScreenAbout
import com.example.catbreedinformation.ui.screen.detail.ScreenDetail
import com.example.catbreedinformation.ui.screen.favorite.ScreenFavorite
import com.example.catbreedinformation.ui.screen.home.ScreenHome

@Composable
fun CatBreedInformationApp(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        bottomBar = {
            BottomBar(
                navController = navController,
                modifier = modifier,
            )
        },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                ScreenHome(modifier = modifier) { name, imageUrl, origin, lifespan, appearance, description ->
                    navController.navigate(
                        Screen.Detail.createRoute(
                            name = name,
                            imageUrl = imageUrl,
                            origin = origin,
                            lifespan = lifespan,
                            appearance = appearance,
                            description = description
                        )
                    )
                }
            }
            composable(
                route = Screen.Detail.route,
                arguments = listOf(
                    navArgument("name") { defaultValue = "" },
                    navArgument("imageUrl") { defaultValue = 0 },
                    navArgument("origin") { defaultValue = "" },
                    navArgument("lifespan") { defaultValue = "" },
                    navArgument("appearance") { defaultValue = "" },
                    navArgument("description") { defaultValue = "" },
                )
            ) {
                val name = it.arguments?.getString("name") ?: ""
                val imageUrl = it.arguments?.getInt("imageUrl") ?: 0
                val origin = it.arguments?.getString("origin") ?: ""
                val lifespan = it.arguments?.getString("lifespan") ?: ""
                val appearance = it.arguments?.getString("appearance") ?: ""
                val description = it.arguments?.getString("description") ?: ""

                ScreenDetail(
                    modifier = modifier,
                    name = name,
                    imageUrl = imageUrl,
                    origin = origin,
                    lifespan = lifespan,
                    appearance = appearance,
                    description = description,
                    onBackButtonClicked = {
                        navController.navigateUp()
                    },
                )
            }
            composable(Screen.Favorite.route) {
                ScreenFavorite(
                    modifier = modifier,
                )
            }
            composable(Screen.About.route) {
                ScreenAbout(
                    modifier = modifier,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CatBreedInformationAppPreview() {
    CatBreedInformationApp(
        navController = rememberNavController(),
        modifier = Modifier,
    )
}