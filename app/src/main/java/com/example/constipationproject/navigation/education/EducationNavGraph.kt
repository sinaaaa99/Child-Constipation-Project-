package com.example.constipationproject.navigation.education

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.constipationproject.navigation.route.EducationMainRoute
import com.example.constipationproject.navigation.route.EducationScreens
import com.example.constipationproject.ui.screen.main.home.education.EducationMenuScreen
import com.example.constipationproject.ui.screen.main.home.education.PointScreen
import com.example.constipationproject.ui.viewmodel.SharedViewModel

fun NavGraphBuilder.educationNavGraph(
    navHostController: NavHostController,
    sharedViewModel: SharedViewModel
) {

    navigation(
        route = EducationMainRoute,
        startDestination = EducationScreens.EducationMenuScreen.route
    ) {

        composable(route = EducationScreens.EducationMenuScreen.route, arguments = listOf(
            navArgument("index") { type = NavType.IntType }
        )) {


            LaunchedEffect(true) {

                val argument = it.arguments
                sharedViewModel.educationType.value = argument?.getInt("index") ?: 1
                sharedViewModel.getTitles()

            }
            EducationMenuScreen(navHostController, sharedViewModel)
        }

        composable(EducationScreens.PointScreen.route, arguments = listOf(
            navArgument("id") {
                type = NavType.IntType
            }
        )) {

            LaunchedEffect(true) {
                val argument = it.arguments
                sharedViewModel.educationId.value = argument?.getInt("id") ?: 1
                sharedViewModel.getTitleWithText()

            }


            PointScreen(navHostController, sharedViewModel)
        }
    }
}