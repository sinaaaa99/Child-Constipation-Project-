package com.example.constipationproject.navigation.note

import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.constipationproject.navigation.route.NoteMainRoute
import com.example.constipationproject.navigation.route.NoteScreens
import com.example.constipationproject.ui.screen.main.note.AddNoteScreen
import com.example.constipationproject.ui.screen.main.note.DetailNoteScreen
import com.example.constipationproject.ui.screen.main.note.ListNoteScreen
import com.example.constipationproject.ui.viewmodel.SharedViewModel

fun NavGraphBuilder.noteNavGraph(
    navHostController: NavHostController,
    sharedViewModel: SharedViewModel
) {

    navigation(startDestination = NoteScreens.ListNoteScreen.route, route = NoteMainRoute) {


        //List Screen
        composable(NoteScreens.ListNoteScreen.route, arguments = listOf(
            navArgument("type") { type = NavType.IntType }
        )) {

            LaunchedEffect(true) {
                val argument = it.arguments
                sharedViewModel.noteType.value = argument?.getInt("type") ?: 1
                sharedViewModel.getNotes()
            }
            ListNoteScreen(navHostController, sharedViewModel)
        }

        //Add Screen
        composable(NoteScreens.AddNoteScreen.route, arguments = listOf(
            navArgument("type") { type = NavType.IntType },
            navArgument("id") { type = NavType.IntType }
        )) {

            LaunchedEffect(true) {
                val argument = it.arguments
                sharedViewModel.noteType.value = argument?.getInt("type") ?: 1
                sharedViewModel.noteId.value = argument?.getInt("id") ?: 0

                if (sharedViewModel.noteId.value != 0) {

                    sharedViewModel.getSingleNote()
                }
            }

            AddNoteScreen(navHostController, sharedViewModel)

        }

        composable(NoteScreens.DetailNoteScreen.route, arguments = listOf(
            navArgument("id") { type = NavType.IntType }
        )) {

            LaunchedEffect(true) {
                val argument = it.arguments
                sharedViewModel.noteId.value = argument?.getInt("id") ?: 0
                sharedViewModel.getSingleNote()

            }
            DetailNoteScreen(navHostController, sharedViewModel)
        }
    }

}