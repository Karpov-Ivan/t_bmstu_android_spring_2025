package com.example.t_bmstu_android_spring_2025.shop

import com.example.t_bmstu_android_spring_2025.models.MonthEnum
import com.example.t_bmstu_android_spring_2025.models.Newspaper

class NewspaperShop : Shop<Newspaper> {
    override fun sell(): Newspaper {
        return Newspaper(888, true, "Свежие новости", 1, MonthEnum.MARCH)
    }
}