package com.example.t_bmstu_android_spring_2025.shop

import com.example.t_bmstu_android_spring_2025.models.LibraryItem

interface Shop<out T : LibraryItem> {
    fun sell(): T
}