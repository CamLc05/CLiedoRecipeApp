package org.example.project

import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.example.project.ui.LoginScreenRoute
import org.example.project.ui.HomeScreenRoute
import org.example.project.ui.RegisterScreenRoute
import org.example.project.ui.RecipeTheme
import org.example.project.ui.screens.Auth.LoginScreen
import org.example.project.ui.screens.Auth.RegisterScreen
import org.example.project.ui.screens.Home.HomeScreen

@Composable
@Preview
fun App() {
    RecipeTheme {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = LoginScreenRoute
        ){
            composable<LoginScreenRoute>{
                LoginScreen(
                    navController
                )
            }
            composable<RegisterScreenRoute>{
                RegisterScreen(
                    navController
                )
            }
            composable<HomeScreenRoute> {
                HomeScreen(
                    navController
                )
            }
        }
    }
}