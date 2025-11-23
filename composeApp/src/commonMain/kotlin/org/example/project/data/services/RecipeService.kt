package org.example.project.data.services

import de.jensklingenberg.ktorfit.http.Body
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.POST
import de.jensklingenberg.ktorfit.http.Query
import org.example.project.models.Prompt
import org.example.project.models.Recipe
import org.example.project.models.RecipePreview

interface RecipeService{
    @GET("recipes")
    suspend fun getRecipesByUserId(@Query("userId") userId: Int) : List<Recipe>

    @POST("recipes/ai-generate")
    suspend fun generateRecipe(@Body request: Prompt): RecipePreview

    @POST("recipes")
    suspend fun saveRecipeInDb(@Body request: Recipe) : Recipe
}