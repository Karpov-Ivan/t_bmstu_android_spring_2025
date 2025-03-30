package com.example.t_bmstu_android_spring_2025.digitization

import com.example.t_bmstu_android_spring_2025.models.Book
import com.example.t_bmstu_android_spring_2025.models.Disk
import com.example.t_bmstu_android_spring_2025.models.DiskType
import com.example.t_bmstu_android_spring_2025.models.LibraryItem
import com.example.t_bmstu_android_spring_2025.models.Newspaper

class DigitizationRoom {
    fun <T : LibraryItem> digitize(item: T): Disk? {
        return when (item) {
            is Book -> Disk(1001, true, "Оцифрованная книга: ${item.name}", DiskType.CD)
            is Newspaper -> Disk(1002, true, "Оцифрованная газета: ${item.name}", DiskType.CD)
            else -> null
        }
    }
}