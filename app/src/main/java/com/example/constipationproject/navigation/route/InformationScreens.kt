package com.example.constipationproject.navigation.route

const val InformationMainRoute = "InformationMainRoute"

sealed class InformationScreens(val route: String) {

    object ParentInformation : InformationScreens("ParentInformationScreen")
    object ChildInformation : InformationScreens("ChildInformationScreen")

}