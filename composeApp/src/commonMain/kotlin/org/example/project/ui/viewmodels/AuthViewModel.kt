package org.example.project.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.ktor.client.request.request
import kotlinx.coroutines.launch
import org.example.project.data.services.KtorfitFactory
import org.example.project.models.LoginBody
import org.example.project.models.RegisterBody

class AuthViewModel() : ViewModel(){
    // Crear la instancia de ktorfit
    // Crear el servicio de auth
    // Mandar a llamar a la api con los datos que me piden
    // TODO: Utilizar este mensaje para un snackbar
    var message by mutableStateOf("")

    val authService = KtorfitFactory.getAuthService()

    fun register(name : String, email : String, password : String){
        viewModelScope.launch {
            try {
                val register = RegisterBody(
                    name = name,
                    email = email,
                    password = password
                )
                val result = authService.register(register)
                if (result.isLogged){
                    // Que el usuario se registro y debo de navegar a otra pantalla
                    // TODO: Crear navegación a homescreen
                } else {
                    // Que no se registro el usuario
                    message = result.message
                }
                println(result.toString())
            }
            catch (e: Exception){
                message = "No se pudo registar el usuario"
                println(e.toString())
            }
        }
    }

    fun login(email: String, password: String){
        viewModelScope.launch {
            try {
                val request = LoginBody(
                    email = email,
                    password = password
                )
                val response = authService.login(request)
                if (response.isLogged){
                    // TODO: Navegar a HomeScreen y guardar el userId en memoria
                } else {
                    message = response.message
                }
            } catch (e: Exception){
                message = "No se pudo iniciar sesión"
                println(e.toString())
            }
        }

    }
}