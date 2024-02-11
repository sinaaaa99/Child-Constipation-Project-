package com.example.constipationproject.data.prepopulate

import com.example.constipationproject.data.model.ConstipationTitle

object PrepopulateConsTitle {

    val listOfTitle = addItemsToTitleEntity()
    private fun addItemsToTitleEntity(): List<ConstipationTitle> {

        return listOf(
            //Type 1
            ConstipationTitle(
                1,
                "تعریف یبوست",
                1
            ),
            ConstipationTitle(
                2,
                "انواع یبوست در کودکان",
                1
            ),
            ConstipationTitle(
                3,
                "نشانه های یبوست",
                1
            ),
            ConstipationTitle(
                4,
                "روش های تشخیص یبوست",
                1
            ),
            ConstipationTitle(
                5,
                "شیوع یبوست",
                1
            ),
            ConstipationTitle(
                6,
                "عوارض یبوست درمان نشده",
                1
            ),
            ConstipationTitle(
                7,
                "درمان یبوست",
                1
            ),
            ConstipationTitle(
                8,
                "پیشگیری از یبوست",
                1
            ),
            ConstipationTitle(
                9,
                "طول مدت درمان یبوست",
                1
            ),

            //Type 2
            ConstipationTitle(
                10,
                "تغذیه و رژیم غذایی",
                2
            ),
            ConstipationTitle(
                11,
                "تحرک و فعالیت بدنی",
                2
            ),
            ConstipationTitle(
                12,
                "مدیریت استرس و مسائل عاطفی",
                2
            ),
            ConstipationTitle(
                13,
                "لزوم مراجعه به پزشک متخصص",
                2
            ),
            ConstipationTitle(
                14,
                "لزوم مصرف داروها طبق دستور پزشک",
                2
            ),

            //Type 3
            ConstipationTitle(
                15,
                "گروه های غذایی",
                3
            ),
            ConstipationTitle(
                16,
                "گروه های غذایی حساسیت زا",
                3
            ),
            ConstipationTitle(
                17,
                "داروها",
                3
            ),
            ConstipationTitle(
                18,
                "مشکلات و مسائل عاطفی",
                3
            ),
            ConstipationTitle(
                19,
                "سایر بیماری ها و عوارض آنها",
                3
            ),
            ConstipationTitle(
                20,
                "تغییر برنامه زندگی",
                3
            ),
            ConstipationTitle(
                21,
                "تعویق در رفتن به سرویس بهداشتی",
                3
            ),
            ConstipationTitle(
                22,
                "آموزش زودهنگام استفاده از توالت",
                3
            )
        )
    }
}