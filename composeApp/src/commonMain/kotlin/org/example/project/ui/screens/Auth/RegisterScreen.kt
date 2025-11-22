package org.example.project.ui.screens.Auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import org.example.project.ui.RecipeTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun RegisterScreen(){
    val colors = MaterialTheme.colorScheme
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colors.background)
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .clip(RoundedCornerShape(
                    bottomStart = 30.dp,
                    bottomEnd = 30.dp,
                ))
                .background(colors.primary)
        )
    }
}

@Preview
@Composable
fun RegisterScreenPreview(){
    RecipeTheme {
        RegisterScreen()
    }
}