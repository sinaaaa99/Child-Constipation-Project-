package com.example.constipationproject.navigation.info

import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.constipationproject.navigation.route.InformationMainRoute
import com.example.constipationproject.navigation.route.InformationScreens
import com.example.constipationproject.ui.screen.main.profile.ChildInformationScreen
import com.example.constipationproject.ui.screen.main.profile.ParentInformationScreen
import com.example.constipationproject.ui.viewmodel.SharedViewModel

fun NavGraphBuilder.informationNavGraph(
    navHostController: NavHostController,
    sharedViewModel: SharedViewModel
) {

    navigation(
        startDestination = InformationScreens.ParentInformation.route,
        route = InformationMainRoute
    ) {

        composable(InformationScreens.ParentInformation.route) {

            LaunchedEffect(true ){
                sharedViewModel.getParentInfo()
            }
            ParentInformationScreen(navHostController, sharedViewModel)
        }

        composable(InformationScreens.ChildInformation.route) {

            LaunchedEffect(true ){
                sharedViewModel.getChildInfo()
            }

            ChildInformationScreen(navHostController, sharedViewModel)
        }

    }


}