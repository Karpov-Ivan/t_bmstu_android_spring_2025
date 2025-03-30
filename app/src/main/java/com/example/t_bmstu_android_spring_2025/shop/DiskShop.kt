package com.example.t_bmstu_android_spring_2025.shop

import com.example.t_bmstu_android_spring_2025.models.Disk

class DiskShop : Shop<Disk>() {
    override fun purchase(): Disk {
        return Disk(777, true, "Новый диск", "DVD")
    }
}