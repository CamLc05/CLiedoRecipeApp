package org.example.project

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import cliedorecipeapp.composeapp.generated.resources.Res
import cliedorecipeapp.composeapp.generated.resources.compose_multiplatform
import org.example.project.ui.RecipeTheme
import org.example.project.ui.screens.Auth.LoginScreen
import org.example.project.ui.screens.Auth.RegisterScreen
import org.example.project.ui.screens.Home.HomeScreen

@Composable
@Preview
fun App() {
    RecipeTheme {
        HomeScreen()
    }
}