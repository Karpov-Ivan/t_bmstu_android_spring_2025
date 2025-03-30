package com.example.t_bmstu_android_spring_2025.models

import models.LibraryItem

class DigitalMedia(id: Int, name: String, type: String) :
    Disk(id, true, name, type) {

    override fun takeHome() {
        if (!isAvailable) {
            println("Этот цифровой носитель уже занят!")
            return
        }
        isAvailable = false
        println("DigitalMedia $id взят домой")
    }
}