package com.example.catbreedinformation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.catbreedinformation.ui.theme.CatBreedInformationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CatBreedInformationTheme {
                CatBreedInformationApp(
                    navController = rememberNavController(),
                    modifier = Modifier,
                )
            }
        }
    }
}