package com.example.t_bmstu_android_spring_2025.models

import com.example.t_bmstu_android_spring_2025.interfaces.Returnable
import com.example.t_bmstu_android_spring_2025.interfaces.TakeHomeable

class Disk(id: Int, isAvailable: Boolean, name: String, val type: String) :
    LibraryItem(id, isAvailable, name), TakeHomeable, Returnable {

    override fun getDetailedInfo(): String =
        "$type $name доступен: ${if (isAvailable) "Да" else "Нет"}"
}
