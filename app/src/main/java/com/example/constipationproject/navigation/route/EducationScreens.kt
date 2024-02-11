package com.example.constipationproject.navigation.route


const val EducationMainRoute = "EducationMainRoute"

sealed class EducationScreens(
    val route: String
) {
    object EducationMenuScreen : EducationScreens(route = "EducationMenuScreen/{index}")
    object PointScreen : EducationScreens(route = "PointScreen/{id}")
}