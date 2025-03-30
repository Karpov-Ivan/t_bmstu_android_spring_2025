package com.example.t_bmstu_android_spring_2025.shop

import com.example.t_bmstu_android_spring_2025.models.Book

class BookShop : Shop<Book>() {
    override fun purchase(): Book {
        return Book(999, true, "Новая книга", 300, "Неизвестный автор")
    }
}