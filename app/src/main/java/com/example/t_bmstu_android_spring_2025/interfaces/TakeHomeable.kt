package com.example.t_bmstu_android_spring_2025.interfaces

import com.example.t_bmstu_android_spring_2025.models.LibraryItem

interface TakeHomeable {
    fun takeHome() {
        val item = this as LibraryItem
        if (!item.isAvailable) {
            println("Этот объект уже занят!")
            return
        }
        item.isAvailable = false
        println("${item::class.simpleName} ${item.id} взят домой")
    }
}
