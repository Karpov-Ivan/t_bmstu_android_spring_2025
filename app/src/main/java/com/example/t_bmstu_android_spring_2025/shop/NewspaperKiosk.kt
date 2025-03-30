package com.example.t_bmstu_android_spring_2025.shop

import android.annotation.SuppressLint
import com.example.t_bmstu_android_spring_2025.models.Newspaper
import java.time.Month

class NewspaperKiosk : Shop<Newspaper>() {
    @SuppressLint("NewApi")
    override fun purchase(): Newspaper {
        return Newspaper(888, true, "Свежие новости", 1, Month.MARCH)
    }
}