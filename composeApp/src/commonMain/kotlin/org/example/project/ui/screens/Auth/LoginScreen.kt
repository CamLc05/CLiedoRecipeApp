package org.example.project.ui.screens.Auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.example.project.ui.OutlineDark
import org.example.project.ui.RecipeTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun LoginScreen(){
    val colors = MaterialTheme.colorScheme
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colors.background)

    ){
        // FONDO
        Column (
            modifier = Modifier
                .fillMaxSize()
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

            Box(
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
        // CARD
        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .align(Alignment.Center)
                .height(350.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(colors.surface),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Bienvenido"
            )
            OutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = { Text("Correo Electrónico") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
            )
            OutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = { Text("Contraseña") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
            )
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview(){
    RecipeTheme {
        LoginScreen()
    }
}