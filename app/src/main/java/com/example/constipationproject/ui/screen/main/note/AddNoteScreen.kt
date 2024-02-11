package com.example.constipationproject.ui.screen.main.note

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.constipationproject.R
import com.example.constipationproject.ui.theme.ConstipationProjectTheme
import com.example.constipationproject.ui.theme.backgroundColor
import com.example.constipationproject.ui.theme.noteMenuColor
import com.example.constipationproject.ui.theme.noteMenuColor1

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNoteScreen() {

    var title by remember {
        mutableStateOf("")
    }

    var description by remember {
        mutableStateOf("")
    }

    var isExpanded by remember {
        mutableStateOf(false)
    }

    var importance by remember {
        mutableStateOf("")
    }
    var importanceType by remember {
        mutableStateOf(0)
    }
    val scrollable = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {

        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            colors = CardDefaults.cardColors(containerColor = noteMenuColor)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
                    .verticalScroll(scrollable),
                verticalArrangement = Arrangement.SpaceBetween
            ) {


                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp, bottom = 12.dp),
                    text = "یادداشت پزشک",
                    style = MaterialTheme.typography.titleMedium
                )
                //title textFiled
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    textStyle = MaterialTheme.typography.titleMedium,
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    value = title,
                    onValueChange = { title = it },
                    placeholder = {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "عنوان",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }, singleLine = true
                )

                Spacer(modifier = Modifier.height(12.dp))

                //importance dropDown
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {

                    ExposedDropdownMenuBox(
                        expanded = isExpanded,
                        onExpandedChange = { isExpanded = it }) {

                        OutlinedTextField(
                            textStyle = MaterialTheme.typography.bodyMedium,
                            value = importance,
                            onValueChange = {},
                            readOnly = true,
                            modifier = Modifier
                                .menuAnchor()
                                .fillMaxWidth()
                                .align(Alignment.Center),
                            placeholder = {

                                Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    text = "اهمیت یادداشت",
                                    style = MaterialTheme.typography.bodyMedium,
                                )
                            },
                            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) },
                            singleLine = true
                        )

                        ExposedDropdownMenu(
                            expanded = isExpanded,
                            onDismissRequest = { isExpanded = false }) {


                            DropdownMenuItem(text = {
                                Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    text = "مهم",
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }, onClick = {

                                //on click
                                importance = "مهم"
                                importanceType = 1
                                isExpanded = false
                            }, trailingIcon = {
                                Box(modifier = Modifier.size(30.dp)) {
                                    Image(
                                        painterResource(id = R.drawable.ic_importance_red),
                                        contentDescription = "importance icon red"
                                    )
                                }
                            })


                            DropdownMenuItem(text = {
                                Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    text = "متوسط",
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }, onClick = {

                                //on click
                                importance = "متوسط"
                                importanceType = 2
                                isExpanded = false
                            }, trailingIcon = {
                                Box(modifier = Modifier.size(30.dp)) {
                                    Image(
                                        painterResource(id = R.drawable.ic_importance_yellow),
                                        contentDescription = "importance icon yellow"
                                    )
                                }
                            })


                            DropdownMenuItem(text = {
                                Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    text = "کم اهمیت",
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }, onClick = {
                                //on click

                                importance = "کم اهمیت"
                                importanceType = 3
                                isExpanded = false

                            }, trailingIcon = {
                                Box(modifier = Modifier.size(30.dp)) {
                                    Image(
                                        painterResource(id = R.drawable.ic_importance_green),
                                        contentDescription = "importance icon red"
                                    )

                                }
                            })
                        }

                    }
                }
                Spacer(modifier = Modifier.height(12.dp))

                //advice textFiled
                OutlinedTextField(modifier = Modifier.fillMaxWidth(),
                    textStyle = MaterialTheme.typography.bodyLarge,
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    value = description,
                    onValueChange = { description = it },
                    placeholder = {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "یادداشت",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    })

                Spacer(modifier = Modifier.height(16.dp))

                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {

                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(noteMenuColor1)
                            .padding(8.dp)
                    ) {

                        Icon(
                            painter = painterResource(id = R.drawable.ic_check),
                            contentDescription = "icon note check"
                        )
                    }

                }
            }
        }
    }


}


@Composable
@Preview(showBackground = true)
fun AddNoteScreenPreview() {

    ConstipationProjectTheme {

        AddNoteScreen()
    }
}