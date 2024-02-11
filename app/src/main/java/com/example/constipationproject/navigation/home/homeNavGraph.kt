package com.example.constipationproject.navigation.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.constipationproject.navigation.route.HomeNavRoute
import com.example.constipationproject.navigation.route.MainScreens
import com.example.constipationproject.ui.viewmodel.SharedViewModel
import com.example.constipationproject.ui.screen.main.home.HomeScreen
import com.example.constipationproject.ui.screen.main.note.NoteScreen
import com.example.constipationproject.ui.screen.main.profile.ProfileScreen

fun NavGraphBuilder.homeNavGraph(
    navHostController: NavHostController,
    sharedViewModel: SharedViewModel,
    padding: PaddingValues
) {

    navigation(startDestination = MainScreens.Home.route, route = HomeNavRoute) {

        composable(route = MainScreens.Home.route) {
            HomeScreen(navHostController, sharedViewModel, padding)
        }
        composable(route = MainScreens.Note.route) {
            NoteScreen(navHostController)
        }
        composable(route = MainScreens.Profile.route) {
            ProfileScreen()
        }
    }
}