package com.example.t_bmstu_android_spring_2025

import com.example.t_bmstu_android_spring_2025.interfaces.ReadableInLibrary
import com.example.t_bmstu_android_spring_2025.interfaces.Returnable
import com.example.t_bmstu_android_spring_2025.interfaces.TakeHomeable
import com.example.t_bmstu_android_spring_2025.models.Book
import com.example.t_bmstu_android_spring_2025.models.Newspaper
import com.example.t_bmstu_android_spring_2025.models.Disk
import com.example.t_bmstu_android_spring_2025.models.LibraryItem
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val libraryItems = mutableListOf(
        Book(101, true, "Маугли", 202, "Редьярд Киплинг"),
        Book(102, true, "Война и мир", 1225, "Лев Толстой"),
        Book(103, true, "Преступление и наказание", 671, "Фёдор Достоевский"),
        Newspaper(201, true, "Сельская жизнь", 794),
        Newspaper(202, true, "Комсомольская правда", 1025),
        Newspaper(203, true, "Известия", 532),
        Disk(301, true, "Дэдпул и Росомаха", "DVD"),
        Disk(302, true, "Матрица", "CD"),
        Disk(303, true, "Интерстеллар", "DVD")
    )

    while (true) {
        println("Выберите категорию:")
        println("1. Показать книги")
        println("2. Показать газеты")
        println("3. Показать диски")
        println("4. Выход")

        when (scanner.nextInt()) {
            1 -> showItems(scanner, libraryItems.filterIsInstance<Book>())
            2 -> showItems(scanner, libraryItems.filterIsInstance<Newspaper>())
            3 -> showItems(scanner, libraryItems.filterIsInstance<Disk>())
            4 -> return
            else -> println("Неверный ввод")
        }
    }
}

fun showItems(scanner: Scanner, items: List<LibraryItem>) {
    if (items.isEmpty()) {
        println("Нет доступных объектов.")
        return
    }

    println("Список доступных объектов:")
    items.forEachIndexed { index, item -> println("${index + 1}. ${item.getShortInfo()}") }
    println("Выберите объект (номер) или 0 для выхода")

    val choice = scanner.nextInt()
    if (choice in 1..items.size) manageItem(scanner, items[choice - 1])
}

fun manageItem(scanner: Scanner, item: LibraryItem) {
    while (true) {
        println("Выберите действие для ${item.name}:")
        println("1. Взять домой")
        println("2. Читать в читальном зале")
        println("3. Показать подробную информацию")
        println("4. Вернуть")
        println("5. Назад")

        when (scanner.nextInt()) {
            1 -> if (item is TakeHomeable) item.takeHome() else println("Нельзя взять этот объект домой!")
            2 -> if (item is ReadableInLibrary) item.readInLibrary() else println("Этот объект нельзя читать в зале!")
            3 -> println(item.getDetailedInfo())
            4 -> if (item is Returnable) item.returnItem() else println("Этот объект нельзя вернуть!")
            5 -> return
            else -> println("Неверный ввод")
        }
    }
}
