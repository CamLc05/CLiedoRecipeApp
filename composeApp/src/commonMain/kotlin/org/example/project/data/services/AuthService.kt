package org.example.project.data.services

import de.jensklingenberg.ktorfit.http.Body
import de.jensklingenberg.ktorfit.http.POST
import org.example.project.models.AuthResponse
import org.example.project.models.LoginBody
import org.example.project.models.RegisterBody

interface AuthService {

    @POST("auth/register")
    suspend fun register(@Body request: RegisterBody) : AuthResponse

    @POST("auth/login")
    suspend fun login(@Body request: LoginBody) : AuthResponse
}