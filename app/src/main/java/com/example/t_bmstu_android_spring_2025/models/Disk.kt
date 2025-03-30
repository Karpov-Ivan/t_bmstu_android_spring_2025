package com.example.t_bmstu_android_spring_2025.models

import com.example.t_bmstu_android_spring_2025.interfaces.TakeHomeable
import models.LibraryItem

open class Disk(
    id: Int,
    isAvailable: Boolean,
    name: String,
    val type: String
) : LibraryItem(id, isAvailable, name), TakeHomeable {

    override fun getDetailedInfo(): String =
        "$type $name доступен: ${if (isAvailable) "Да" else "Нет"}"

    override fun takeHome() {
        if (!isAvailable) {
            println("Этот объект уже занят!")
            return
        }
        isAvailable = false
        println("Диск $id взят домой")
    }
}
