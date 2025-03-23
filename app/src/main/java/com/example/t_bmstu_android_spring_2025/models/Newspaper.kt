package com.example.t_bmstu_android_spring_2025.models

import com.example.t_bmstu_android_spring_2025.interfaces.ReadableInLibrary
import com.example.t_bmstu_android_spring_2025.interfaces.Returnable

class Newspaper(id: Int, isAvailable: Boolean, name: String, val issueNumber: Int) :
    LibraryItem(id, isAvailable, name), ReadableInLibrary, Returnable {

    override fun getDetailedInfo(): String =
        "Выпуск: $issueNumber газеты $name с id: $id доступен: ${if (isAvailable) "Да" else "Нет"}"
}
