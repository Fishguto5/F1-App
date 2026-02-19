package com.example.f1.data.model

import kotlinx.serialization.Serializable

@Serializable
// In this class we are defining the data that we want to get from the JSON API
data class SessionResponse(
    val location: String,
    //@Serial Name is used to simplify the name of the variable in the JSON,
    // for exemple the name in the JSON is first_name but is not a good practice to use _
    // in Kt develop and we can rename like firstname
    //@SerialName("first_name") val firstname: String
)