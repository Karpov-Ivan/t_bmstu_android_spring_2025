package com.example.t_bmstu_android_spring_2025.models

import com.example.t_bmstu_android_spring_2025.interfaces.TakeHomeable
import interfaces.ReadableInLibrary
import models.LibraryItem

class Book(
    id: Int,
    isAvailable: Boolean,
    name: String,
    val pages: Int,
    val author: String
) : LibraryItem(id, isAvailable, name), TakeHomeable, ReadableInLibrary {

    override fun getDetailedInfo(): String =
        "Книга: $name ($pages стр.) автора: $author с id: $id доступна: ${if (isAvailable) "Да" else "Нет"}"

    override fun takeHome() {
        if (!isAvailable) {
            println("Этот объект уже занят!")
            return
        }
        isAvailable = false
        println("Книга $id взята домой")
    }

    override fun readInLibrary() {
        if (!isAvailable) {
            println("Этот объект уже занят!")
            return
        }
        isAvailable = false
        println("Книга $id взята в читальный зал")
    }
}
