package com.example.constipationproject.navigation.note

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.constipationproject.navigation.route.NoteMainRoute
import com.example.constipationproject.navigation.route.NoteScreens
import com.example.constipationproject.ui.screen.main.note.AddNoteScreen
import com.example.constipationproject.ui.screen.main.note.ListNoteScreen
import com.example.constipationproject.ui.viewmodel.SharedViewModel

fun NavGraphBuilder.noteNavGraph(
    navHostController: NavHostController,
    sharedViewModel: SharedViewModel
) {

    navigation(startDestination = NoteScreens.ListNoteScreen.route, route = NoteMainRoute) {


        //List Screen
        composable(NoteScreens.ListNoteScreen.route) {

            ListNoteScreen()
        }

        //Add Screen
        composable(NoteScreens.AddNoteScreen.route) {

            AddNoteScreen()

        }
    }

}