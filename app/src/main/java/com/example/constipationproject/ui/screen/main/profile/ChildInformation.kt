package com.example.constipationproject.ui.screen.main.profile

import androidx.compose.animation.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.constipationproject.R
import com.example.constipationproject.data.model.ChildInfo
import com.example.constipationproject.ui.theme.ConstipationProjectTheme
import com.example.constipationproject.ui.theme.backgroundColor
import com.example.constipationproject.ui.theme.infoSelectedColor
import com.example.constipationproject.ui.theme.menuItemColor4
import com.example.constipationproject.ui.theme.saveButtonColor
import com.example.constipationproject.ui.viewmodel.SharedViewModel
import com.example.constipationproject.util.RequestState

@Composable
fun ChildInformationScreen(navHostController: NavHostController, sharedViewModel: SharedViewModel) {

    var isBoySelected by remember {
        mutableStateOf(false)
    }
    var isGirlSelected by remember {
        mutableStateOf(false)
    }
    val selectColorBoy = remember {
        Animatable(backgroundColor)
    }
    val selectColorGirl = remember {
        Animatable(backgroundColor)
    }
    val scrollable = rememberScrollState()

    LaunchedEffect(key1 = isGirlSelected, key2 = isBoySelected) {
        if (isGirlSelected) {
            selectColorGirl.animateTo(infoSelectedColor, tween(500))
            selectColorBoy.animateTo(backgroundColor, tween(500))
        }
        if (isBoySelected) {
            selectColorBoy.animateTo(infoSelectedColor, tween(500))
            selectColorGirl.animateTo(backgroundColor, tween(500))
        }
    }

    var childName by remember {
        mutableStateOf("")
    }

    var childAge by remember {
        mutableStateOf("")
    }

    var childWeight by remember {
        mutableStateOf("")
    }

    var childTall by remember {
        mutableStateOf("")
    }

    var childMedicine by remember {
        mutableStateOf("")
    }

    var childIllness by remember {
        mutableStateOf("")
    }

    val getChildInfo by sharedViewModel.cInfo.collectAsState()

    if (getChildInfo is RequestState.Success) {

        val childInfo = (getChildInfo as RequestState.Success<ChildInfo>).data

        childInfo?.let { childInfo ->

            LaunchedEffect(true) {

                childName = childInfo.name
                childAge = childInfo.age
                childIllness = childInfo.illness
                childMedicine = childInfo.medicine
                childTall = childInfo.tall
                childWeight = childInfo.weight

                when (childInfo.sex) {
                    1 -> {
                        isBoySelected = true
                    }

                    2 -> {
                        isGirlSelected = true
                    }

                    else -> {
                        isBoySelected = false
                        isGirlSelected = false
                    }

                }
            }
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .verticalScroll(scrollable)
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
                text = "اطلاعات کودک",
                style = MaterialTheme.typography.titleMedium
            )

        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                modifier = Modifier
                    .border(width = 3.dp, selectColorGirl.value, CircleShape)
                    .clip(CircleShape)
                    .clickable {
                        isGirlSelected = true
                        isBoySelected = false
                    }
                    .padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {

                Image(
                    modifier = Modifier.padding(horizontal = 12.dp),
                    painter = painterResource(id = R.drawable.ic_girl),
                    contentDescription = "girl icon"
                )
                Text(text = "دختر", style = MaterialTheme.typography.bodyMedium)
            }

            Column(
                modifier = Modifier
                    .border(width = 3.dp, selectColorBoy.value, CircleShape)
                    .clip(CircleShape)
                    .clickable {
                        isGirlSelected = false
                        isBoySelected = true
                    }
                    .padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {

                Image(
                    modifier = Modifier.padding(horizontal = 12.dp),
                    painter = painterResource(id = R.drawable.ic_boy),
                    contentDescription = "boy icon"
                )
                Text(text = "پسر", style = MaterialTheme.typography.bodyMedium)
            }

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "نام فرزند",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(4.dp))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = childName,
                onValueChange = { childName = it })

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "سن فرزند",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(4.dp))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = childAge,
                onValueChange = { childAge = it })

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "وزن فرزند",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(4.dp))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = childWeight,
                onValueChange = { childWeight = it })

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "قد فرزند",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(4.dp))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = childTall,
                onValueChange = { childTall = it })

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "داروهای مصرفی فرزند",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(4.dp))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = childMedicine,
                onValueChange = { childMedicine = it })

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "بیماری های فرزند", style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(4.dp))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = childIllness,
                onValueChange = { childIllness = it })

        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            contentAlignment = Alignment.Center
        ) {

            Button(
                colors = ButtonDefaults.buttonColors(containerColor = saveButtonColor),
                onClick = {

                    //on Save button Click
                    val sex = if (isBoySelected) {
                        1
                    } else if (isGirlSelected) {
                        2
                    } else {
                        0
                    }
                    val childInfo = ChildInfo(
                        1,
                        sex,
                        childName,
                        childAge,
                        childWeight,
                        childTall,
                        childMedicine,
                        childIllness
                    )

                    sharedViewModel.insertChildInfo(childInfo)
                    navHostController.popBackStack()

                }) {
                Text(text = "ذخیره", style = MaterialTheme.typography.bodyMedium)
            }

        }
    }
}

@Composable
@Preview(showBackground = true)
fun ChildInformationPreview() {
    ConstipationProjectTheme {
//        ChildInformationScreen()

    }
}