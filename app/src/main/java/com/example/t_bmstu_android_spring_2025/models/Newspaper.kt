package com.example.t_bmstu_android_spring_2025.models

import android.os.Build
import androidx.annotation.RequiresApi
import interfaces.ReadableInLibrary
import models.LibraryItem
import java.time.Month

class Newspaper(
    id: Int,
    isAvailable: Boolean,
    name: String,
    val issueNumber: Int,
    val month: Month
) : LibraryItem(id, isAvailable, name), ReadableInLibrary {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun getDetailedInfo(): String =
        "Выпуск: $issueNumber газеты $name (${month.getDisplayName(java.time.format.TextStyle.FULL, java.util.Locale("ru"))}) с id: $id доступен: ${if (isAvailable) "Да" else "Нет"}"

    override fun readInLibrary() {
        if (!isAvailable) {
            println("Этот объект уже занят!")
            return
        }
        isAvailable = false
        println("Газета $id взята в читальный зал")
    }
}

