package com.example.f1.ui.components.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LogInButton(modifier: Modifier){

    Button(
        modifier = Modifier.fillMaxWidth(0.5f),
        colors = ButtonDefaults.buttonColors(Color.Red),
        onClick = {},
        shape = RoundedCornerShape(15.dp)
    ){
        Text(
            text = "Log In",
            color = Color.White,
            fontSize = 15.sp
        )
    }
}