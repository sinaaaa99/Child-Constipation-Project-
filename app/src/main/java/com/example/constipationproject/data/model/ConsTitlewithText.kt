package com.example.constipationproject.data.model

import androidx.room.Embedded
import androidx.room.Relation


data class ConsTitleWithText(
    @Embedded val title: ConstipationTitle,
    @Relation(
        parentColumn = "id",
        entityColumn = "parentId"
    ) val text: List<ConstipationText>
)
