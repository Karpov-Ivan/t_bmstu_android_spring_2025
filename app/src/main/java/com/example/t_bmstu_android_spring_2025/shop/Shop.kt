package com.example.t_bmstu_android_spring_2025.shop

import com.example.t_bmstu_android_spring_2025.interfaces.Purchasable
import com.example.t_bmstu_android_spring_2025.models.LibraryItem

abstract class Shop<T : LibraryItem> : Purchasable<T>