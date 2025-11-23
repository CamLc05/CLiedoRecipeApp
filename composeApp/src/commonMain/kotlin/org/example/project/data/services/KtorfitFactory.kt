package org.example.project.data.services

import androidx.compose.animation.defaultDecayAnimationSpec
import de.jensklingenberg.ktorfit.Ktorfit
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.accept
import io.ktor.client.request.request
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import io.ktor.util.Platform
import kotlinx.serialization.json.Json
import kotlin.math.exp

object KtorfitFactory{
    val base = "https://recipes.pjasoft.com/api/"

    // Clientes http, axios, fetch
    // NO TENEMOS CERTEZA QUE LA API RESPONDA SIEMPRE IGUAL
    // QUE PASA SI LA API NO RESPONDE CON EL STATUS CODE 200
    // API TARD EN RESPONDER -> 10S
    private val httpClient = HttpClient {
        expectSuccess = false
        // Permite que la api tarde más en su respuesta, por defecto solo da 10 segundos
        install(HttpTimeout){
            requestTimeoutMillis = 40000
            connectTimeoutMillis = 40000
            socketTimeoutMillis = 40000
        }

        install(ContentNegotiation){
            json(
                Json {
                    isLenient = true // Permite jsons imperfectos o incompletos
                    ignoreUnknownKeys = true // Ignora propiedades desconocidas
                }
            )
        }
        defaultRequest {
            contentType(ContentType.Application.Json)
            accept(ContentType.Application.Json)
        }
    }
    private val ktorfit = Ktorfit
        .Builder()
        .httpClient(httpClient)
        .baseUrl(base)
        .build()

    fun getAuthService() : AuthService {
        return ktorfit.createAuthService()
    }

    fun getRecipeService() : RecipeService {
        return ktorfit.createRecipeService()
    }

}