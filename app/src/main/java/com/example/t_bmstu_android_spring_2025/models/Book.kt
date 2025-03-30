package com.example.t_bmstu_android_spring_2025.models

import com.example.t_bmstu_android_spring_2025.interfaces.ReadableInLibrary
import com.example.t_bmstu_android_spring_2025.interfaces.Returnable
import com.example.t_bmstu_android_spring_2025.interfaces.TakeHomeable

class Book(id: Int, isAvailable: Boolean, name: String, val pages: Int, val author: String) :
    LibraryItem(id, isAvailable, name), TakeHomeable, ReadableInLibrary, Returnable {

    override fun getDetailedInfo(): String =
        "Книга: $name ($pages стр.) автора: $author с id: $id доступна: ${if (isAvailable) "Да" else "Нет"}"
}
