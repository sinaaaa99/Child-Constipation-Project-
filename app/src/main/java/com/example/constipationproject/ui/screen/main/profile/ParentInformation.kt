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
import com.example.constipationproject.data.model.ParentInfo
import com.example.constipationproject.ui.theme.ConstipationProjectTheme
import com.example.constipationproject.ui.theme.backgroundColor
import com.example.constipationproject.ui.theme.infoSelectedColor
import com.example.constipationproject.ui.theme.menuItemColor4
import com.example.constipationproject.ui.theme.saveButtonColor
import com.example.constipationproject.ui.viewmodel.SharedViewModel
import com.example.constipationproject.util.RequestState

@Composable
fun ParentInformationScreen(
    navHostController: NavHostController,
    sharedViewModel: SharedViewModel
) {

    var isDadSelected by remember {
        mutableStateOf(false)
    }
    var isMomSelected by remember {
        mutableStateOf(false)
    }
    val selectColorDad = remember {
        Animatable(backgroundColor)
    }
    val selectColorMom = remember {
        Animatable(backgroundColor)
    }
    val scrollable = rememberScrollState()

    var parentName by remember {
        mutableStateOf("")
    }

    var parentAge by remember {
        mutableStateOf("")
    }

    var parentStudyLevel by remember {
        mutableStateOf("")
    }

    var parentJob by remember {
        mutableStateOf("")
    }

    var parentMarried by remember {
        mutableStateOf("")
    }

    var parentIncome by remember {
        mutableStateOf("")
    }

    var parentLocation by remember {
        mutableStateOf("")
    }

    var parentPhone by remember {
        mutableStateOf("")
    }

    var parentHealthStatus by remember {
        mutableStateOf("")
    }

    val getParentInfo by sharedViewModel.pInfo.collectAsState()

    if (getParentInfo is RequestState.Success) {

        val parentInfo = (getParentInfo as RequestState.Success<ParentInfo>).data

        parentInfo?.let { parentInfo ->

            LaunchedEffect(true) {

                parentName = parentInfo.name
                parentAge = parentInfo.age
                parentHealthStatus = parentInfo.healthStatus
                parentIncome = parentInfo.income
                parentJob = parentInfo.job
                parentLocation = parentInfo.location
                parentMarried = parentInfo.married
                parentPhone = parentInfo.phone
                parentStudyLevel = parentInfo.studyLevel

                when (parentInfo.sex) {
                    1 -> {
                        isDadSelected = true
                    }

                    2 -> {
                        isMomSelected = true
                    }

                    else -> {
                        isDadSelected = false
                        isMomSelected = false
                    }

                }
            }
        }
    }
    LaunchedEffect(key1 = isMomSelected, key2 = isDadSelected) {
        if (isMomSelected) {
            selectColorMom.animateTo(infoSelectedColor, tween(500))
            selectColorDad.animateTo(backgroundColor, tween(500))
        }
        if (isDadSelected) {
            selectColorDad.animateTo(infoSelectedColor, tween(500))
            selectColorMom.animateTo(backgroundColor, tween(500))
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
                text = "اطلاعات والد",
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
                    .border(width = 3.dp, selectColorMom.value, CircleShape)
                    .clip(CircleShape)
                    .clickable {
                        isMomSelected = true
                        isDadSelected = false
                    }
                    .padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {

                Image(
                    modifier = Modifier.padding(horizontal = 12.dp),
                    painter = painterResource(id = R.drawable.ic_girl),
                    contentDescription = "Mom icon"
                )
                Text(text = "مادر", style = MaterialTheme.typography.bodyMedium)
            }

            Column(
                modifier = Modifier
                    .border(width = 3.dp, selectColorDad.value, CircleShape)
                    .clip(CircleShape)
                    .clickable {
                        isMomSelected = false
                        isDadSelected = true
                    }
                    .padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {

                Image(
                    modifier = Modifier.padding(horizontal = 12.dp),
                    painter = painterResource(id = R.drawable.ic_boy),
                    contentDescription = "Dad icon"
                )
                Text(text = "پدر", style = MaterialTheme.typography.bodyMedium)
            }

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "نام",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(4.dp))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = parentName,
                onValueChange = { parentName = it })

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "سن",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(4.dp))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = parentAge,
                onValueChange = { parentAge = it })

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "سطح تحصیلات",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(4.dp))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = parentStudyLevel,
                onValueChange = { parentStudyLevel = it })

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "شغل",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(4.dp))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = parentJob,
                onValueChange = { parentJob = it })

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "وضعیت تاهل(زندگی با همسر ، بدون همسر)",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(4.dp))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = parentMarried,
                onValueChange = { parentMarried = it })

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "درآمد ماهیانه خانواده", style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(4.dp))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = parentIncome,
                onValueChange = { parentIncome = it })

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "محل سکونت", style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(4.dp))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = parentLocation,
                onValueChange = { parentLocation = it })

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "شماره تماس", style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(4.dp))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = parentPhone,
                onValueChange = { parentPhone = it })

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "سابقه یبوست در خانواده", style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(4.dp))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = parentHealthStatus,
                onValueChange = { parentHealthStatus = it })

        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp), contentAlignment = Alignment.Center
        ) {

            Button(
                colors = ButtonDefaults.buttonColors(containerColor = saveButtonColor),
                onClick = {
                    //on Save button Click
                    val sex = if (isDadSelected) {
                        1
                    } else if (isMomSelected) {
                        2
                    } else {
                        0
                    }
                    val parentInfo = ParentInfo(
                        1,
                        sex,
                        parentName,
                        parentAge,
                        parentStudyLevel,
                        parentJob,
                        parentMarried,
                        parentIncome,
                        parentLocation,
                        parentPhone,
                        parentHealthStatus
                    )

                    sharedViewModel.insertParentInfo(parentInfo)
                    navHostController.popBackStack()
                }) {
                Text(text = "ذخیره", style = MaterialTheme.typography.bodyMedium)
            }

        }
    }
}

@Composable
@Preview(showBackground = true)
fun ParentInformationPreview() {

    ConstipationProjectTheme {
//        ParentInformationScreen()
    }
}