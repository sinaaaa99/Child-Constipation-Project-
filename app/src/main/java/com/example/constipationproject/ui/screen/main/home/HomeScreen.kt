package com.example.constipationproject.ui.screen.main.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.constipationproject.data.MenuClass
import com.example.constipationproject.navigation.route.EducationScreens
import com.example.constipationproject.ui.viewmodel.SharedViewModel
import com.example.constipationproject.ui.theme.backgroundColor
import com.example.constipationproject.util.RequestState

@Composable
fun HomeScreen(
    navHostController: NavHostController,
    sharedViewModel: SharedViewModel,
    padding: PaddingValues
) {

    val menuItems by sharedViewModel.menuItems.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(padding)
            .padding(top = 12.dp, start = 12.dp, end = 12.dp),
    ) {

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            text = "یبوست عملکردی",
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 10.dp, bottom = 8.dp),
            text = "اطلاعات مربوط به آموزش والدین کودک",
            style = MaterialTheme.typography.bodyMedium
        )
        LazyColumn {

            if (menuItems is RequestState.Success) {

                itemsIndexed((menuItems as RequestState.Success<List<MenuClass>>).data) { index, item ->

                    MenuItem(menuClass = item) {

                        //on Card Click
                        val whichItem = index + 1
                        navHostController.navigate("EducationMenuScreen/$whichItem")
                    }
                }
            }
        }
    }
}