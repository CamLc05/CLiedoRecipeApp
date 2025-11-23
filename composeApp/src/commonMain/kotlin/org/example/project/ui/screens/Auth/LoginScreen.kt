package org.example.project.ui.screens.Auth

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.example.project.ui.OutlineDark
import org.example.project.ui.RecipeTheme
import org.example.project.ui.viewmodels.AuthViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun LoginScreen(){
    val colors = MaterialTheme.colorScheme
    val authViewModel : AuthViewModel = viewModel()

    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colors.background)

    ){
        // Fondo
        Column(
            modifier = Modifier.fillMaxSize()
        )
        {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .clip(RoundedCornerShape(
                        bottomStart = 30.dp,
                        bottomEnd = 30.dp
                    ))
                    .background(colors.primary)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            )

        }

        // Card
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 20.dp)
                .height(350.dp)
                .width(340.dp)
                .shadow(
                    elevation = 8.dp,
                    shape = RoundedCornerShape(24.dp)
                )
                .clip(RoundedCornerShape(24.dp))
                .background(colors.surface),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            Text(
                text = "Bienvenido",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
            Spacer(
                modifier = Modifier
                    .height(15.dp)
            )
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                placeholder = { Text("Correo Electrónico") },
                modifier = Modifier
                    .width(300.dp),
                shape = RoundedCornerShape(30.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    cursorColor = colors.primary
                )
            )

            Spacer(
                modifier = Modifier
                    .height(15.dp)
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = { Text("Contraseña") },
                modifier = Modifier
                    .width(300.dp),
                shape = RoundedCornerShape(30.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    cursorColor = colors.primary
                )
            )

            Spacer(
                modifier = Modifier
                    .height(15.dp)
            )
            Button(
                modifier = Modifier
                    .width(300.dp)
                    .height(50.dp),
                onClick = {
                    if (email.isBlank() || password.isBlank()) {
                        println("Por favor, complete todos los campos.")
                        return@Button
                    }

                    authViewModel.login(
                        email = email,
                        password = password
                    )
                },
                colors = ButtonDefaults.buttonColors()
            ){
                Text("Iniciar Sesión")
            }

            Spacer(
                modifier = Modifier
                    .height(5.dp)
            )

            Text(
                text = "¿No tienes una cuenta? Crea una",
                fontSize = 15.sp,
                color = colors.primary,
                modifier = Modifier
                    .clickable {
                        // navegacion
                    }
                    .padding(8.dp)
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