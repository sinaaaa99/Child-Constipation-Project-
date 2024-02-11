package com.example.constipationproject.ui.screen.main.home.education

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.constipationproject.R
import com.example.constipationproject.data.model.ConstipationTitle
import com.example.constipationproject.ui.theme.ConstipationProjectTheme
import com.example.constipationproject.ui.theme.EducationMenuItemArrowColor
import com.example.constipationproject.ui.theme.EducationMenuItemColor1
import com.example.constipationproject.ui.theme.EducationMenuItemColor2
import com.example.constipationproject.ui.theme.EducationMenuItemColor3
import com.example.constipationproject.ui.theme.EducationMenuItemColor4
import com.example.constipationproject.ui.theme.EducationMenuItemColor5
import com.example.constipationproject.ui.theme.EducationMenuItemColor6
import com.example.constipationproject.ui.theme.EducationMenuItemColor7
import com.example.constipationproject.ui.theme.EducationMenuItemColor8
import com.example.constipationproject.ui.theme.EducationMenuItemDividerColor
import com.example.constipationproject.ui.theme.backgroundColor
import com.example.constipationproject.ui.theme.menuItemColor2
import com.example.constipationproject.ui.theme.menuItemColor3
import com.example.constipationproject.ui.theme.menuItemColor4

@Composable
fun EduItems(constipationTitle: ConstipationTitle, cardColor: Color, onClickListener: () -> Unit) {


//    val cardColor = colors.random()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .padding(8.dp)
    ) {


        Card(
            modifier = Modifier
                .fillMaxHeight()
                .weight(10f),
            colors = CardDefaults.cardColors(
                containerColor = cardColor
            )
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(backgroundColor)
                            .clickable { onClickListener() },
                        contentAlignment = Alignment.Center
                    ) {

                        Icon(
                            painter = painterResource(id = R.drawable.ic_arrows_left),
                            contentDescription = "icon arrow left"
                        )

                    }

                    Text(
                        text = constipationTitle.title,
                        style = MaterialTheme.typography.titleMedium
                    )
                }

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "4 نکته",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }

        //divider....................
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .size(20.dp)
                    .clip(CircleShape)
                    .background(cardColor)
            )

            Divider(
                modifier = Modifier
                    .width(1.dp)
                    .fillMaxHeight()
                    .padding(vertical = 3.dp), color = cardColor
            )
        }
    }

}

@Composable
@Preview(showBackground = true)
fun EduItemsPrev() {
    ConstipationProjectTheme {

//        EduItems()
    }
}