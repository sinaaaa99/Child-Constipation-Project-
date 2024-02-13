package com.example.constipationproject.ui.screen.main.note

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.constipationproject.R
import com.example.constipationproject.ui.theme.ConstipationProjectTheme
import com.example.constipationproject.ui.theme.noteMenuColor
import com.example.constipationproject.ui.theme.noteMenuColor1
import com.example.constipationproject.ui.theme.noteMenuColor2
import com.example.constipationproject.ui.theme.noteMenuColor3

@Composable
fun NoteScreen(navHostController: NavHostController) {

    Column(modifier = Modifier.fillMaxSize()) {


        //doctor Notes................................
        NoteCard(
            title = "یادداشت پزشک",

            onListClick = {
                //on Doctor List Click
                navHostController.navigate("ListNoteScreen/1")

            }, onAddClick = {
                //on Doctor Add Click
                navHostController.navigate("AddNoteScreen/1/0")

            })

        //parents Note................................
        NoteCard(
            title = "یادداشت والد",

            onListClick = {
                //on parent List Click
                navHostController.navigate("ListNoteScreen/2")

            }, onAddClick = {
                //on parent Add Click
                navHostController.navigate("AddNoteScreen/2/0")

            })

    }
}

@Composable
fun NoteCard(title: String, onListClick: () -> Unit, onAddClick: () -> Unit) {
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
                .padding(12.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                text = title,
                style = MaterialTheme.typography.titleMedium
            )

            Divider(
                modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            )
            Divider(
                modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
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
                            //list click
                            onListClick()
                        }
                        .padding(8.dp)
                ) {

                    Icon(
                        painter = painterResource(id = R.drawable.ic_note_list),
                        contentDescription = "icon note list"
                    )
                }

                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(noteMenuColor1)
                        .clickable {
                            //add click
                            onAddClick()
                        }
                        .padding(8.dp)
                ) {

                    Icon(
                        painter = painterResource(id = R.drawable.ic_note_pen),
                        contentDescription = "icon note pen"
                    )
                }

            }
        }


    }
}

@Composable
@Preview(showBackground = true)
fun NoteScreenPreview() {

    ConstipationProjectTheme {

//        NoteScreen()
    }
}