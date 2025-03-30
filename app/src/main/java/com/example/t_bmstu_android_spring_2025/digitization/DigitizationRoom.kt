package com.example.t_bmstu_android_spring_2025.digitization

import com.example.t_bmstu_android_spring_2025.models.Book
import com.example.t_bmstu_android_spring_2025.models.DigitalMedia
import com.example.t_bmstu_android_spring_2025.models.Newspaper

class DigitizationRoom {
    fun digitize(item: Any): DigitalMedia? {
        return when (item) {
            is Book -> DigitalMedia(1001, "Оцифрованная книга: ${item.name}", "CD")
            is Newspaper -> DigitalMedia(1002, "Оцифрованная газета: ${item.name}", "CD")
            else -> null
        }
    }
}