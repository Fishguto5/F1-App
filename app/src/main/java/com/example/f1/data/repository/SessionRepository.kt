package com.example.f1.data.repository

import com.example.f1.data.model.SessionResponse
import com.example.f1.data.network.RetrofitClient

class SessionRepository {
    private val api = RetrofitClient.apiService

    suspend fun fetchF1Sessions(country: String): List<SessionResponse>{
        return api.getSessions(country)
    }
}