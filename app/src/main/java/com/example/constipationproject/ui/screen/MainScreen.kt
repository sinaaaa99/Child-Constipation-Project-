package com.example.constipationproject.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.constipationproject.navigation.MainGraph
import com.example.constipationproject.navigation.route.MainScreens
import com.example.constipationproject.ui.screen.main.CustomBottomBar
import com.example.constipationproject.ui.viewmodel.SharedViewModel
import com.example.constipationproject.ui.theme.bottomBarColor
import com.example.constipationproject.ui.theme.indicatorItemColor


@Composable
fun MainScreen(navHostController: NavHostController, sharedViewModel: SharedViewModel) {


    Scaffold(

        bottomBar = {
            CustomBottomBar(navHostController)
        }
    ) { padding ->

        MainGraph(navHostController, sharedViewModel, padding)
    }
}