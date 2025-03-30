package com.example.t_bmstu_android_spring_2025.models

import com.example.t_bmstu_android_spring_2025.interfaces.Returnable
import com.example.t_bmstu_android_spring_2025.interfaces.TakeHomeable

open class Disk(id: Int, isAvailable: Boolean, name: String, val type: DiskType) :
    LibraryItem(id, isAvailable, name), TakeHomeable {

    override fun getDetailedInfo(): String =
        "${type.name} $name доступен: ${if (isAvailable) "Да" else "Нет"}"

    override fun takeHome() {
        if (!isAvailable) {
            println("Этот объект уже занят!")
            return
        }
        isAvailable = false
        println("Диск $id взят домой")
    }
}
