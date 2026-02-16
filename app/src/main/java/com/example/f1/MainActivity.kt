package com.example.f1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.f1.ui.theme.F1Theme
import androidx.compose.foundation.text.BasicTextField

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
                        F1Logo(Modifier)
                    }
                }
            }
        }
    }
}

@Composable
fun F1Logo( modifier: Modifier = Modifier) {
    Box(
        modifier.fillMaxWidth(0.3f).padding(top = 16.dp),
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(id = R.drawable.f1logo),
            contentDescription = "F1 Logo",
            modifier = modifier.fillMaxWidth(1f)
        )
    }
}

@Composable
fun TextFieldBox(
    modifier: Modifier
){
    BasicTextField(
        state = rememberTextFieldState("Hello\nWorld\nInvisible"),
        lineLimits = TextFieldLineLimits.MultiLine(maxHeightInLines = 2),
        modifier = modifier.padding(20.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    F1Theme {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            F1Logo(Modifier)
        }
    }
}