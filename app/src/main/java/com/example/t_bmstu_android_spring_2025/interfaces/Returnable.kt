package com.example.t_bmstu_android_spring_2025.interfaces

import com.example.t_bmstu_android_spring_2025.models.LibraryItem

interface Returnable {
    fun returnItem() {
        val item = this as LibraryItem
        if (item.isAvailable) {
            println("Этот объект уже доступен, его нельзя вернуть!")
            return
        }
        item.isAvailable = true
        println("${item::class.simpleName} ${item.id} возвращен")
    }
}
