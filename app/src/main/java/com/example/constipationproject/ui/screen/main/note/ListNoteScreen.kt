package com.example.constipationproject.ui.screen.main.note

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.constipationproject.R
import com.example.constipationproject.data.model.Note
import com.example.constipationproject.navigation.route.NoteScreens
import com.example.constipationproject.ui.theme.backgroundColor
import com.example.constipationproject.ui.theme.menuItemColor4
import com.example.constipationproject.ui.theme.noteMenuColor
import com.example.constipationproject.ui.theme.noteMenuColor1
import com.example.constipationproject.ui.viewmodel.SharedViewModel
import com.example.constipationproject.util.RequestState

@Composable
fun ListNoteScreen(navHostController: NavHostController, sharedViewModel: SharedViewModel) {

    val noteType by sharedViewModel.noteType.collectAsState()
    val notes by sharedViewModel.notes.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(menuItemColor4)
                    .clickable { navHostController.popBackStack() }
                    .padding(8.dp)
            ) {

                Icon(
                    painter = painterResource(id = R.drawable.left_arrow),
                    contentDescription = "back Icon"
                )
            }

            Text(
                text = when (noteType) {
                    1 -> {
                        "یادداشت های پزشک"
                    }

                    2 -> {
                        "یادداشت های والد"
                    }

                    else -> {
                        "یادداشت های پزشک"
                    }
                }, style = MaterialTheme.typography.titleMedium
            )

        }



        LazyColumn {

            if (notes is RequestState.Success) {

                itemsIndexed((notes as RequestState.Success<List<Note>>).data) { _, note ->

                    NoteItem(note,
                        onTrashClick = {
                            //on Trash Click
                            sharedViewModel.noteId.value = note.id
                            sharedViewModel.deleteNote()

                        }, onZoomClick = {
                            //on Zoom Click
                            navHostController.navigate("DetailNoteScreen/${note.id}")

                        }, onPenClick = {
                            //on Pen Click
//                            sharedViewModel.noteId.value = note.id
                            navHostController.navigate("AddNoteScreen/${note.type}/${note.id}")

                        })

                }
            }

        }

    }
}


@Composable
fun NoteItem(
    note: Note,
    onTrashClick: () -> Unit,
    onZoomClick: () -> Unit,
    onPenClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .padding(start = 24.dp, end = 24.dp, top = 24.dp),
        colors = CardDefaults.cardColors(containerColor = noteMenuColor)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {

            Row(verticalAlignment = Alignment.CenterVertically) {


                Image(
                    modifier = Modifier.size(30.dp),
                    painter = painterResource(
                        id = when (note.importance) {
                            1 -> {
                                R.drawable.ic_importance_red
                            }

                            2 -> {
                                R.drawable.ic_importance_yellow
                            }

                            3 -> {
                                R.drawable.ic_importance_green
                            }

                            else -> {
                                R.drawable.ic_importance_green
                            }
                        }
                    ),
                    contentDescription = "importance of note image"
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    text = note.title,
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .padding(horizontal = 10.dp)
            )

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    text = note.text,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {

                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(noteMenuColor1)
                            .clickable {
                                //on Trash click
                                onTrashClick()
                            }
                            .padding(8.dp)
                    ) {

                        Icon(
                            painter = painterResource(id = R.drawable.ic_trash),
                            contentDescription = "icon Full Screen"
                        )
                    }

                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(noteMenuColor1)
                            .clickable {
                                //on Zoom click
                                onZoomClick()
                            }
                            .padding(8.dp)
                    ) {

                        Icon(
                            painter = painterResource(id = R.drawable.ic_fullscreen),
                            contentDescription = "icon Full Screen"
                        )
                    }

                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(noteMenuColor1)
                            .clickable {
                                //on Pen click
                                onPenClick()
                            }
                            .padding(8.dp)
                    ) {

                        Icon(
                            painter = painterResource(id = R.drawable.ic_note_pen),
                            contentDescription = "icon Full Screen"
                        )
                    }
                }
            }


        }


    }
}

@Composable
@Preview(showBackground = true)
fun ListNoteScreenPreview() {

//    ListNoteScreen()
}