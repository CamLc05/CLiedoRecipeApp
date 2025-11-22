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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.ui.RecipeTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun RegisterScreen(){
    val colors = MaterialTheme.colorScheme
    var name by remember{
        mutableStateOf("")
    }
    var email by remember{
        mutableStateOf("")
    }
    var password by remember{
        mutableStateOf("")
    }
    var confirmPassword by remember{
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
                .height(420.dp)
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
                text = "Crear cuenta",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )

            Spacer(
                modifier = Modifier
                    .height(15.dp)
            )

            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                placeholder = { Text("Nombre") },
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

            OutlinedTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                placeholder = { Text("Confirmar contraseña") },
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
                onClick = {},
                colors = ButtonDefaults.buttonColors()
            ){
                Text("Registrarse")
            }
        }
    }
}

@Preview
@Composable
fun RegisterScreenPreview(){
    RecipeTheme {
        RegisterScreen()
    }
}