package com.example.constipationproject.data.prepopulate

import com.example.constipationproject.R
import com.example.constipationproject.data.MenuClass
import com.example.constipationproject.ui.theme.menuItemColor1
import com.example.constipationproject.ui.theme.menuItemColor2
import com.example.constipationproject.ui.theme.menuItemColor3
import com.example.constipationproject.ui.theme.menuItemColor4

object PrepopulateMenuItem {

    fun listOfMenuItem(): List<MenuClass> {
        return listOf(
            MenuClass(
                "اطلاعات مربوط به بیماری یبوست",
                "9 درس",
                R.drawable.teaching_parent,
                menuItemColor1
            ),
            MenuClass(
                "مدیریت سبک زندگی و لزوم مصرف داروها",
                "5 درس",
                R.drawable.child_medicine,
                menuItemColor2
            ),
            MenuClass(
                "علل ایجاد کننده یبوست عملکردی کودکان",
                "8 درس",
                R.drawable.constipation_child,
                menuItemColor3
            ),
            MenuClass(
                "فیلم های آموزشی",
                "4 فیلم",
                R.drawable.media_content,
                menuItemColor4
            ),
        )

    }
}