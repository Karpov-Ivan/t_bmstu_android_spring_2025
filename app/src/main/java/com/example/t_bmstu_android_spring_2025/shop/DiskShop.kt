package com.example.t_bmstu_android_spring_2025.shop

import com.example.t_bmstu_android_spring_2025.models.Disk
import com.example.t_bmstu_android_spring_2025.models.DiskType

class DiskShop : Shop<Disk> {
    override fun sell(): Disk {
        return Disk(777, true, "Новый диск", DiskType.DVD)
    }
}