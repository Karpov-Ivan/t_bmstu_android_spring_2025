package com.example.t_bmstu_android_spring_2025.management

import com.example.t_bmstu_android_spring_2025.models.LibraryItem
import com.example.t_bmstu_android_spring_2025.shop.Shop

class Manager {
    fun <T : LibraryItem> buy(shop: Shop<T>): T {
        return shop.sell()
    }
}