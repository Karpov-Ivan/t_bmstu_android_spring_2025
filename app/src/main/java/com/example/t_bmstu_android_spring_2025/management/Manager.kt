package com.example.t_bmstu_android_spring_2025.management

import com.example.t_bmstu_android_spring_2025.shop.Shop
import models.LibraryItem

class Manager {
    fun <T : LibraryItem> buy(shop: Shop<T>): T {
        return shop.purchase()
    }
}