package com.example.constipationproject.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.constipationproject.navigation.education.educationNavGraph
import com.example.constipationproject.navigation.home.homeNavGraph
import com.example.constipationproject.navigation.note.noteNavGraph
import com.example.constipationproject.navigation.route.HomeNavRoute
import com.example.constipationproject.ui.viewmodel.SharedViewModel

@Composable
fun MainGraph(
    navHostController: NavHostController,
    sharedViewModel: SharedViewModel,
    padding: PaddingValues
) {

    NavHost(
        navController = navHostController,
        startDestination = HomeNavRoute,
        route = "MainGraph"
    ) {

        homeNavGraph(navHostController, sharedViewModel, padding)

        educationNavGraph(navHostController, sharedViewModel)

        noteNavGraph(navHostController,sharedViewModel)
    }
}