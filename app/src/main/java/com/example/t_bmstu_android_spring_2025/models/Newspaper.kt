package com.example.t_bmstu_android_spring_2025.models

import com.example.t_bmstu_android_spring_2025.interfaces.ReadableInLibrary
import com.example.t_bmstu_android_spring_2025.interfaces.Returnable
import java.time.Month

class Newspaper(id: Int, isAvailable: Boolean, name: String, val issueNumber: Int, val month: Month) :
    LibraryItem(id, isAvailable, name), ReadableInLibrary, Returnable {

    override fun getDetailedInfo(): String =
        "Выпуск: $issueNumber газеты $name ($month) с id: $id доступен: ${if (isAvailable) "Да" else "Нет"}"
}
