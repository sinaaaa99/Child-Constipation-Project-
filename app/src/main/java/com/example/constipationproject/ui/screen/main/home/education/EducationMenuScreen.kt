package com.example.constipationproject.ui.screen.main.home.education

import android.util.Log
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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.constipationproject.R
import com.example.constipationproject.data.model.ConstipationTitle
import com.example.constipationproject.ui.theme.ConstipationProjectTheme
import com.example.constipationproject.ui.theme.EducationMenuItemColor1
import com.example.constipationproject.ui.theme.EducationMenuItemColor2
import com.example.constipationproject.ui.theme.EducationMenuItemColor3
import com.example.constipationproject.ui.theme.EducationMenuItemColor4
import com.example.constipationproject.ui.theme.EducationMenuItemColor5
import com.example.constipationproject.ui.theme.EducationMenuItemColor6
import com.example.constipationproject.ui.theme.EducationMenuItemColor7
import com.example.constipationproject.ui.theme.EducationMenuItemColor8
import com.example.constipationproject.ui.theme.menuItemColor1
import com.example.constipationproject.ui.theme.menuItemColor2
import com.example.constipationproject.ui.theme.menuItemColor3
import com.example.constipationproject.ui.theme.menuItemColor4
import com.example.constipationproject.ui.viewmodel.SharedViewModel
import com.example.constipationproject.util.RequestState

@Composable
fun EducationMenuScreen(navHostController: NavHostController, sharedViewModel: SharedViewModel) {


    val consTitles by sharedViewModel.titles.collectAsState()

    val educationType by sharedViewModel.educationType.collectAsState()

    val colors = listOf(
        EducationMenuItemColor8,
        EducationMenuItemColor1,
        EducationMenuItemColor2,
        EducationMenuItemColor3,
        EducationMenuItemColor4,
        EducationMenuItemColor5,
        EducationMenuItemColor6,
        EducationMenuItemColor7,
        EducationMenuItemColor8,
        EducationMenuItemColor8,
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
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

            Box(
                modifier = Modifier
                    .size(50.dp)
                    .padding(8.dp)
            ) {

                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = "search Icon"
                )
            }

        }


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 24.dp)
        ) {

            Text(
                text = "Lets Learn More ...",
                style = MaterialTheme.typography.titleLarge.copy(textDirection = TextDirection.Ltr)
            )

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(top = 12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = when (educationType) {
                        1 -> {
                            menuItemColor1
                        }

                        2 -> {
                            menuItemColor2
                        }

                        3 -> {
                            menuItemColor3
                        }

                        4 -> {
                            menuItemColor4
                        }

                        else -> {
                            menuItemColor1
                        }
                    }
                )
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Image(
                        painter = painterResource(
                            id = when (educationType) {
                                1 -> {
                                    R.drawable.teaching_parent
                                }

                                2 -> {
                                    R.drawable.child_medicine
                                }

                                3 -> {
                                    R.drawable.constipation_child
                                }

                                else -> {
                                    R.drawable.media_content
                                }
                            }
                        ),
                        contentDescription = "Education Menu Main Item Image"
                    )

                    Text(
                        text = when (educationType) {
                            1 -> {
                                "اطلاعات مربوط به بیماری یبوست"
                            }

                            2 -> {
                                "مدیریت سبک زندگی و لزوم مصرف داروها"
                            }

                            3 -> {
                                "علل ایجاد یبوست عملکردی کودکان"
                            }

                            else -> {
                                ""
                            }

                        },
                        style = MaterialTheme.typography.titleMedium
                    )

                }

            }

            //items.................................................
            LazyColumn {

                if (consTitles is RequestState.Success) {

                    itemsIndexed((consTitles as RequestState.Success<List<ConstipationTitle>>).data) { index, data ->

                        EduItems(data, colors[index]) {

                            //on left arrow click
                            navHostController.navigate("PointScreen/${data.id}")

                        }
                    }

                }
            }

        }

    }
}

@Composable
@Preview(showBackground = true)
fun EducationMenuPrev() {
    ConstipationProjectTheme {

//        EducationMenuScreen()
    }
}