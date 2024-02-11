package com.example.constipationproject.ui.screen.main.home.education


import android.widget.Toast
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.constipationproject.R
import com.example.constipationproject.data.model.ConsTitleWithText
import com.example.constipationproject.data.model.ConstipationText
import com.example.constipationproject.ui.theme.ConstipationProjectTheme
import com.example.constipationproject.ui.theme.backgroundColor
import com.example.constipationproject.ui.theme.menuItemColor1
import com.example.constipationproject.ui.theme.menuItemColor2
import com.example.constipationproject.ui.theme.menuItemColor3
import com.example.constipationproject.ui.theme.menuItemColor4
import com.example.constipationproject.ui.theme.pointBackgroundColor
import com.example.constipationproject.ui.viewmodel.SharedViewModel
import com.example.constipationproject.util.RequestState

@Composable
fun PointScreen(
    navHostController: NavHostController,
    sharedViewModel: SharedViewModel
) {

    val titleAndText by sharedViewModel.titleAndText.collectAsState()
    val shownPointIndex by sharedViewModel.shownPointIndex.collectAsState()
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        if (titleAndText is RequestState.Success) {

            val listOfTitleWithText =
                (titleAndText as RequestState.Success<ConsTitleWithText>).data

            val titleAndTextById = listOfTitleWithText.text[shownPointIndex]

            ShowPoints(
                points = titleAndTextById,
                title = listOfTitleWithText.title.title,
                navHostController = navHostController,
                sharedViewModel = sharedViewModel
            ) {
                //on increase Click
                val listSize = listOfTitleWithText.text.size

                if (shownPointIndex == (listSize - 1)) {
                    Toast.makeText(context, "نکات همین ها بود:)", Toast.LENGTH_SHORT).show()
                } else {
                    sharedViewModel.increaseShownPoint()
                }
            }
        }


    }
}

@Composable
fun ShowPoints(
    points: ConstipationText,
    title: String,
    navHostController: NavHostController,
    sharedViewModel: SharedViewModel,
    onIncreaseClick: () -> Unit
) {

    Column(modifier = Modifier.fillMaxSize()) {

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

            Text(text = title, style = MaterialTheme.typography.titleMedium)

        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .clip(
                    RoundedCornerShape(topStart = 250.dp, topEnd = 250.dp)
                )
                .background(pointBackgroundColor),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                modifier = Modifier.padding(top = 8.dp),
                contentScale = ContentScale.FillHeight,
                painter = painterResource(id = R.drawable.im_point_main),
                contentDescription = "Point Main Image"
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Divider(
                    modifier = Modifier
                        .height(1.dp)
                        .width(50.dp)
                        .clip(RoundedCornerShape(50.dp))
                )

                Row(
                    modifier = Modifier
                        .padding(vertical = 8.dp, horizontal = 4.dp)
                        .width(80.dp)
                        .height(30.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(backgroundColor),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Icon(
                        modifier = Modifier.clickable {
                            sharedViewModel.decreaseShownPoint()
                        },
                        imageVector = Icons.Filled.KeyboardArrowLeft,
                        contentDescription = "KeyboardArrowLeft"
                    )

                    Icon(
                        modifier = Modifier.clickable {
                            onIncreaseClick()
                        },
                        imageVector = Icons.Filled.KeyboardArrowRight,
                        contentDescription = "KeyboardArrowRight"
                    )
                }

                Divider(
                    modifier = Modifier
                        .height(1.dp)
                        .width(50.dp)
                        .clip(RoundedCornerShape(50.dp))
                )
            }

            //show content

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp)
            ) {


                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    text = points.title,
                    style = MaterialTheme.typography.titleMedium,
                    color = backgroundColor
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.Center
                ) {


                    Text(
                        modifier = Modifier
                            .weight(8f),
                        text = points.text,
                        style = MaterialTheme.typography.bodyLarge,
                        color = backgroundColor,
                        textAlign = TextAlign.Center
                    )

                    Icon(tint = backgroundColor,
                        modifier = Modifier.size(25.dp).padding(top = 8.dp),
                        painter = painterResource(id = R.drawable.ic_point),
                        contentDescription = "point icon"
                    )
                }


            }
        }

    }

}

@Composable
@Preview(showBackground = true)
fun PointScreenPreview() {

    ConstipationProjectTheme {

//        PointScreen()
    }

}