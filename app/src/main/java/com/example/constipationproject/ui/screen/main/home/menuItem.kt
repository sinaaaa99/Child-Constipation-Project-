package com.example.constipationproject.ui.screen.main.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.constipationproject.data.MenuClass

@Composable
fun MenuItem(menuClass: MenuClass, onCardClickListener: () -> Unit) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clickable { onCardClickListener() }
            .padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(containerColor = menuClass.backgroundColor)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Image(
                painter = painterResource(id = menuClass.image),
                contentDescription = "menu item image"
            )

            Column(
                Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = menuClass.title,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(text = menuClass.subTitle, style = MaterialTheme.typography.bodyLarge)
            }


        }

    }
}

@Composable
@Preview
fun MenuItemPreview() {
//    MenuItem()
}