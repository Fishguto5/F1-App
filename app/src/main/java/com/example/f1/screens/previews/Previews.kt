package com.example.f1.screens.previews

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.f1.components.buttons.LogInButton
import com.example.f1.screens.logIn.TextFieldBox
import com.example.f1.ui.theme.F1Theme

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
        LogInButton(Modifier)
    }
}