package com.example.f1.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.f1.data.repository.SessionRepository
import kotlinx.coroutines.launch

class SessionViewModel: ViewModel() {
    private val repository = SessionRepository()

    fun getSessions(country: String){
        viewModelScope.launch {
            try {
                val sessions = repository.fetchF1Sessions(country)
                sessions.forEach {
                    session -> println("Localização encontrada:" + session.location)
                }
            } catch (e: Exception){
                println("Erro ao buscar dados: ${e.message}")
            }
        }
    }
}