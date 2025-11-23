package org.example.project.models

import kotlinx.serialization.Serializable

@Serializable
data class LoginBody(
    val email : String,
    val password : String
)
