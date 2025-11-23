package org.example.project.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.ktor.client.request.request
import kotlinx.coroutines.launch
import org.example.project.data.services.KtorfitFactory
import org.example.project.data.services.Preferences
import org.example.project.models.LoginBody
import org.example.project.models.RegisterBody
import kotlin.toString


class AuthViewModel() : ViewModel(){
    // DE ALGUNA FOMRA !!! CREAR LA INSTANCIA DE KTORFIT
    // CREAR EL SERVICIO DE AUTH
    // ,ANDAR A LLAMAR LA API CON LOS DATOS QUE ME PIDEN
    // TODO: UTILIZAR ESTE MENSAJE PARA UN SNACKBAR

    val preferences = Preferences
    var message by mutableStateOf("")
    val authService = KtorfitFactory.getAuthService()
    var isLogged by mutableStateOf(preferences.getIsLogged())

    fun register(name:String, email: String, password: String){
        viewModelScope.launch {
            try {
                val register = RegisterBody(
                    name = name,
                    email = email,
                    password = password
                )

                val result = authService.register(register)
                if (result.isLogged){
                    // QUE EL USUARIO SE REGISTRO Y DEBO DE NAVEGAR A OTRA PANTALLA
                    // TODO: CREAR NAVEGACION A HOMESCREEN
                    isLogged = true
                    preferences.saveIsLogged(true)
                    preferences.saveUserId(result.userId)
                }
                else {
                    // QUE NO SE PUDO CREAR EL USUARIO
                    message = result.message
                }
                println(result.toString())

            }
            catch (e : Exception){
                message = "No se pudo registrar el usuario"
                println(e.toString())
            }
        }
    }

    fun login(email:String, password : String){
        viewModelScope.launch {
            try {
                val request = LoginBody(
                    email = email,
                    password = password
                )
                val response = authService.login(request)
                if(response.isLogged){
                    // TODO: NAVEGAR A HOME Y GUARDAR EL USUARIO EN MEMMORIA
                    isLogged = true
                    preferences.saveIsLogged(true)
                    preferences.saveUserId(response.userId)
                }
                else {
                    message = response.message
                }
            }
            catch (e:Exception){
                println(e.toString())
            }
        }
    }
}