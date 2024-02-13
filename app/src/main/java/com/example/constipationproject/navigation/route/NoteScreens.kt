package com.example.constipationproject.navigation.route

const val NoteMainRoute = "NoteMainRoute"

sealed class NoteScreens(val route: String) {
    object AddNoteScreen : NoteScreens("AddNoteScreen/{type}/{id}")
    object ListNoteScreen : NoteScreens("ListNoteScreen/{type}")
    object DetailNoteScreen : NoteScreens("DetailNoteScreen/{id}")
}