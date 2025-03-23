package com.example.t_bmstu_android_spring_2025.models

abstract class LibraryItem(val id: Int, var isAvailable: Boolean, val name: String) {
    abstract fun getDetailedInfo(): String
    open fun getShortInfo(): String = "$name доступна: ${if (isAvailable) "Да" else "Нет"}"
}
