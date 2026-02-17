package com.example.f1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicSecureTextField
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        Modifier.padding(top = 30.dp),
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(id = R.drawable.f1logo),
            contentDescription = "F1 Logo",
            modifier = modifier.height(200.dp).width(200.dp)
        )
    }
}

@Composable
fun TextFieldBox(
    modifier: Modifier,
   emailInput: TextFieldState = rememberTextFieldState(""),
    passwordInput: TextFieldState = rememberTextFieldState("")
){
    val brush = Brush.linearGradient(
        colors = listOf(
            Color.Black,
            Color.Blue,
            Color.Magenta,
            Color.Red
        )
    )
    var passwordState by remember { mutableStateOf(true) }
    var passwordIcon by remember { mutableStateOf(Icons.Default.Close) }

    fun clickPasswordIcon (){
        passwordState = !passwordState
        if (passwordState){
            passwordIcon = Icons.Default.Close
        }else{
            passwordIcon = Icons.Default.CheckCircle
        }
    }
    BasicTextField(
        state = emailInput ,
        lineLimits = TextFieldLineLimits.MultiLine(maxHeightInLines = 1),
        modifier = modifier
            .fillMaxWidth(0.7f)
            .clip(RoundedCornerShape(15.dp))
            .height(45.dp)
            .background(Color.White)
            .border(
                shape = RoundedCornerShape(15.dp),
                width = 1.dp,
                color = Color.Red
            )
        ,
        textStyle = TextStyle(
            brush = brush,
            fontSize = 15.sp,
        ),
        decorator = {
            innerTextField ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    modifier = Modifier.padding(start = 10.dp).height(15.dp).padding(end = 10.dp),
                    imageVector = Icons.Default.Email,
                    contentDescription = null
                )
                Box(Modifier){
                    if(emailInput.text.isEmpty()){ //Método nativo do Kotlin
                        Text(
                            modifier = Modifier,
                            fontSize = 15.sp,
                             text = "Email"
                        )
                    }else {
                        innerTextField()
                    }
                }
            }
        }
    )
    Spacer(modifier = Modifier.height(25.dp))
    BasicSecureTextField(
        state = passwordInput ,
        textObfuscationMode = if (passwordState) {
            TextObfuscationMode.Visible
        } else {
            TextObfuscationMode.Hidden
        },
        modifier = modifier
            .fillMaxWidth(0.7f)
            .clip(RoundedCornerShape(15.dp))
            .height(45.dp)
            .background(Color.White)
            .border(
                shape = RoundedCornerShape(15.dp),
                width = 1.dp,
                color = Color.Red
            )
        ,
        textStyle = TextStyle(
            brush = brush,
            fontSize = 15.sp,
        ),

        decorator = {
                innerTextField ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    modifier = Modifier.padding(start = 10.dp).height(15.dp).padding(end = 15.dp),
                    imageVector = Icons.Default.Lock,
                    contentDescription = null
                )

                Box(Modifier.weight(1f).padding(end = 5.dp)){
                    if(passwordInput.text.isEmpty()){ //Método nativo do Kotlin
                        Text(
                            modifier = Modifier,
                            fontSize = 15.sp,
                            text = "Senha"
                        )
                    }else {
                        innerTextField()
                    }
                }
                IconButton(
                    onClick = {clickPasswordIcon()},
                    modifier = Modifier.padding(end = 5.dp),

                ){
                    Icon(
                        modifier = Modifier,
                        imageVector = passwordIcon,
                        contentDescription = null
                    )
                }
            }
        },
    )
}

@Composable
fun LogInButton(){

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

@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    F1Theme {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            F1Logo(Modifier)
            Spacer(Modifier.height(20.dp))
            TextFieldBox(Modifier)
            Spacer(Modifier.height(20.dp))
            LogInButton()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TextFieldPreview() {
    F1Theme {
        TextFieldBox(Modifier.fillMaxWidth())
    }
}

@Preview(showBackground = true)
@Composable
fun LogInButtonPreview() {
    F1Theme {
        LogInButton()
    }
}