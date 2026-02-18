package com.example.f1.components.naviagtionBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Android
import androidx.compose.material.icons.filled.PeopleAlt
import androidx.compose.material.icons.filled.TrackChanges
import androidx.compose.ui.graphics.vector.ImageVector

enum class Destination(
    val route: String,
    val label: String,
    val icon: ImageVector,
    val contentDescription: String
) {
    HOME("home", "Home", Icons.Default.Android, "Home"),
    PILOTS("pilots", "Pilots", Icons.Default.PeopleAlt, "Pilots"),
    TRACKS("tracks", "Tracks", Icons.Default.TrackChanges, "Tracks"),
    PROFILE("profile", "Profile", Icons.Default.PeopleAlt, "Profile"),
    CHAT("chat", "Chat", Icons.Default.Android, "Chat")
}