package com.example.constipationproject.navigation.route

import com.example.constipationproject.R


const val HomeNavRoute = "HomeNavRoute"

sealed class MainScreens(
    val route: String,
    val name: String,
    val icon: Int,
) {
    object Home : MainScreens("HomeScreen", "خانه", R.drawable.ic_home)
    object Profile : MainScreens("ProfileScreen", "پروفایل", R.drawable.ic_profile)
    object Note : MainScreens("NoteScreen", "یادداشت", R.drawable.ic_note)
}