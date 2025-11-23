package org.example.project.models

import kotlinx.serialization.Serializable

@Serializable
data class Prompt (
    val ingredients: String
)
