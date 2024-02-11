package com.example.constipationproject.ui.screen.main

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
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.constipationproject.navigation.route.MainScreens
import com.example.constipationproject.ui.theme.bottomBarColor
import com.example.constipationproject.ui.theme.indicatorItemColor

@Composable
fun CustomBottomBar(navHostController: NavHostController) {

    val bottomBarItems = listOf(
        MainScreens.Profile,
        MainScreens.Home,
        MainScreens.Note
    )

    var selectedItemIndex by rememberSaveable {
        mutableStateOf(1)
    }

    val navBackStack by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStack?.destination

    val checkDestination = bottomBarItems.any { it.route == currentDestination?.route }
    if (checkDestination) {

        NavigationBar(
            modifier = Modifier
                .padding(12.dp)
                .clip(RoundedCornerShape(40.dp)),
            containerColor = bottomBarColor
        ) {

            bottomBarItems.forEachIndexed { index, item ->

                NavigationBarItem(
                    modifier = Modifier.fillMaxHeight(),
                    selected = selectedItemIndex == index,
                    onClick = {
                        selectedItemIndex = index
                        navHostController.navigate(item.route)
                    },
                    icon = {
                        Box(
                            modifier = Modifier
                                .height(55.dp)
                                .width(25.dp)
                                .clip(CircleShape), contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(id = item.icon),
                                contentDescription = item.route
                            )
                        }

                    },
                    alwaysShowLabel = false,
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = bottomBarColor,
                        indicatorColor = indicatorItemColor
                    )
                )
            }

        }
    }
}