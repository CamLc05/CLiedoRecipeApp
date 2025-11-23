package org.example.project.ui.screens.Home

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.example.project.ui.RecipeTheme
import org.example.project.ui.components.RecipeCard
import org.example.project.ui.viewmodels.HomeViewModel
import org.example.project.utils.hideKeyboard
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen() {
    val colors = MaterialTheme.colorScheme
    val container = if (isSystemInDarkTheme()) colors.surface else Color.White
    val vm: HomeViewModel = viewModel()
    val focusManager = LocalFocusManager.current
    var prompt by remember {
        mutableStateOf("")
    }


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(colors.background)
            .padding(15.dp)
    ) {
        // Header
        item {
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Column (
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Text(
                        text = "Hola"
                    )
                    Text(
                        text = "Camila",
                        fontWeight = FontWeight.Bold
                    )
                }
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(
                            colors.primary.copy(alpha = 0.2f)
                        ),
                    contentAlignment = Alignment.Center

                ){
                    Text(
                        text = "C",
                        fontWeight = FontWeight.Bold,
                        color = colors.primary
                    )
                }
                IconButton(
                    onClick = {}
                ){
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.Logout,
                        contentDescription = "Logout",
                        tint = colors.primary
                    )
                }
            }
        }
        // Generate recipe
        item {
            Spacer(
                modifier = Modifier
                    .height(15.dp)
            )
            Text(
                text = "Crea, cocina, comparte y disfruta"
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = prompt,
                onValueChange = { prompt = it },
                shape = CircleShape,
                singleLine = true,
                placeholder = { Text("Escribe tus ingredientes...") },
                trailingIcon = {
                    IconButton(
                        onClick = {
                            hideKeyboard(
                                focusManager = focusManager
                            )
                        }
                    ){
                        Icon(
                            imageVector = Icons.Default.AutoAwesome,
                            contentDescription = "Generar receta",
                            tint = Color.White,
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                                .background(colors.primary)
                                .padding(5.dp)
                        )
                    }
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = container,
                    unfocusedContainerColor = container,
                    disabledContainerColor = container,
                    errorContainerColor = container,
                    focusedBorderColor = colors.primary,
                    unfocusedBorderColor = colors.primary.copy(alpha = 0.6f),
                    cursorColor = colors.primary,
                    focusedTextColor = colors.onSurface,
                    unfocusedTextColor = colors.onSurface,
                    focusedPlaceholderColor = colors.onSurfaceVariant,
                    unfocusedPlaceholderColor = colors.onSurfaceVariant
                )
            )
        }

        item {
            Text(text = "Tus recetas recientes", color = colors.onSurface)
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(vm.recentRecipes){ recipe ->
                    RecipeCard(
                        recipe,
                        onClick = {

                        }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    RecipeTheme {
        HomeScreen()
    }
}
