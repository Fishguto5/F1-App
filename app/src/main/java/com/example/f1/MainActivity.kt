package com.example.f1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.f1.screens.logIn.InitialScreen
import com.example.f1.ui.theme.F1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            F1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) {innerPadding ->
                    Column(
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        InitialScreen()
                    }
                }
            }
        }
    }
}

