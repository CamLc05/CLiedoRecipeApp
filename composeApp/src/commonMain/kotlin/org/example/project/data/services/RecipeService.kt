package org.example.project.data.services

import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Query
import org.example.project.models.Recipe

interface RecipeService{
    @GET("recipes")
    suspend fun getRecipesByUserId(@Query("userId") userId: Int) : List<Recipe>
}