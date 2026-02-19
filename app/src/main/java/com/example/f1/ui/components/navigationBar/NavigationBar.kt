package com.example.f1.ui.components.navigationBar

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController

@Composable
fun NavigationBar(navController: NavHostController){
    val startDestination = Destination.HOME
    var selectedDestination by remember { mutableStateOf(startDestination.ordinal)}
    NavigationBar(
        modifier = Modifier,
        containerColor = Color.Red,
        windowInsets = NavigationBarDefaults.windowInsets
    ) {
        Destination.entries.forEachIndexed{ index, destination ->
            NavigationBarItem(
                selected = selectedDestination == index,
                onClick = {
                    navController.navigate(route = destination.route)
                    selectedDestination = index
                },
                icon = {
                    Icon(
                        destination.icon,
                        contentDescription = destination.contentDescription
                    )
                },
                label = {Text(destination.label)}
            )
            
        }
    }
}