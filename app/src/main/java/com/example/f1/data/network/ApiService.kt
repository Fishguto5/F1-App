package com.example.f1.data.network

import com.example.f1.data.model.SessionResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("sessions")
    // the suspend shows that this function can demand a long time to execute and it can pause the aap
    // suspend is a coroutine of Kotlin
    suspend fun getSessions(
        @Query("country_name") country: String,
        //@Query("first_name") firstName:String
    ): List<SessionResponse>

}