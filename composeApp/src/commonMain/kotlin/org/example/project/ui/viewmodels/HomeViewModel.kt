package org.example.project.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.example.project.data.services.KtorfitFactory
import org.example.project.models.Prompt
import org.example.project.models.Recipe
import org.example.project.models.RecipePreview

class HomeViewModel : ViewModel(){
    private val recipeService = KtorfitFactory.getRecipeService()
    var ingredients by mutableStateOf("")
    var generatedRecipe by mutableStateOf<RecipePreview?>(null)
    var recentRecipes by mutableStateOf<List<Recipe>>(listOf())
    var recipes by mutableStateOf<List<Recipe>>(listOf())
    var showSheet by mutableStateOf(false)
    val userId = 2 // TODO: Obtener el userId del usuario logueado
    var isLoading by mutableStateOf(false)

    init {
        loadRecipes()
    }

    fun loadRecipes(){
        viewModelScope.launch {
            try {
                isLoading = true
                val result = recipeService.getRecipesByUserId(userId)
                recipes = result
                recentRecipes = recipes.takeLast(5).reversed()
                println("Recetas cargadas: ${result}")
            }catch (e: Exception){
                println("Error al cargar las recetas: ${e}")
            }
            finally {
                isLoading = false
            }
        }
    }

    fun generateRecipe(onShowSheet: ()->Unit){
        viewModelScope.launch {
            try {
                isLoading = true
                if (ingredients.isBlank()){
                    println("No se proporcionaron ingredientes.")
                    return@launch
                }
                val prompt = Prompt(
                    ingredients = ingredients
                )
                val result = recipeService.generateRecipe(prompt)
                generatedRecipe = result
                showSheet = true
                println("Receta generada: ${result}")
            }catch (e: Exception){
                println("Error al generar la receta: ${e}")
            }
            finally {
                isLoading = false
            }
        }
    }
    fun showModalFromList(recipe: RecipePreview){
        showSheet = true
        generatedRecipe = recipe
    }

    fun hidemodal(){
        showSheet = false
        generatedRecipe = null
    }
}
