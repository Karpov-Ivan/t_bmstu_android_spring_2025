package com.example.t_bmstu_android_spring_2025

import android.annotation.SuppressLint
import com.example.t_bmstu_android_spring_2025.digitization.DigitizationRoom
import com.example.t_bmstu_android_spring_2025.interfaces.TakeHomeable
import com.example.t_bmstu_android_spring_2025.management.Manager
import com.example.t_bmstu_android_spring_2025.models.Book
import com.example.t_bmstu_android_spring_2025.models.Newspaper
import com.example.t_bmstu_android_spring_2025.models.Disk
import com.example.t_bmstu_android_spring_2025.shop.BookShop
import com.example.t_bmstu_android_spring_2025.shop.DiskShop
import com.example.t_bmstu_android_spring_2025.shop.NewspaperKiosk
import interfaces.ReadableInLibrary
import interfaces.Returnable
import models.LibraryItem
import java.time.Month
import java.util.Scanner

@SuppressLint("NewApi")
fun main() {
    val scanner = Scanner(System.`in`)
    val manager = Manager()
    val digitizationRoom = DigitizationRoom()

    val items: MutableList<LibraryItem> = mutableListOf(
        Book(101, true, "Маугли", 202, "Редьярд Киплинг"),
        Newspaper(201, true, "Сельская жизнь", 794, Month.FEBRUARY),
        Disk(301, true, "Дэдпул и Росомаха", "DVD")
    )

    while (true) {
        println("Меню:")
        println("1. Показать библиотеку")
        println("2. Купить новый объект")
        println("3. Оцифровать объект")
        println("4. Выход")

        when (scanner.nextInt()) {
            1 -> {
                println("Выберите тип:")
                println("1. Книги")
                println("2. Газеты")
                println("3. Диски")
                println("4. Назад")

                when (scanner.nextInt()) {
                    1 -> showItems(scanner, items.filterIsInstance<Book>())
                    2 -> showItems(scanner, items.filterIsInstance<Newspaper>())
                    3 -> showItems(scanner, items.filterIsInstance<Disk>())
                }
            }
            2 -> {
                println("Выберите магазин: 1. Книги, 2. Газеты, 3. Диски")
                val purchased = when (scanner.nextInt()) {
                    1 -> manager.buy(BookShop())
                    2 -> manager.buy(NewspaperKiosk())
                    3 -> manager.buy(DiskShop())
                    else -> null
                }
                purchased?.let { items.add(it); println("Куплен: ${it.getShortInfo()}") }
            }
            3 -> {
                println("Выберите объект для оцифровки:")
                val booksAndNewspapers = items.filter { it is Book || it is Newspaper }
                booksAndNewspapers.forEachIndexed { i, item -> println("$i: ${item.getShortInfo()}") }

                val choice = scanner.nextInt()
                if (choice in booksAndNewspapers.indices) {
                    val digitized = digitizationRoom.digitize(booksAndNewspapers[choice])
                    digitized?.let { items.add(it); println("Оцифровано: ${it.getShortInfo()}") }
                } else {
                    println("Неверный выбор")
                }

            }
            4 -> return
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
    if (choice == 0) return
    if (choice in 1..items.size) manageItem(scanner, items[choice - 1])
    else println("Неверный ввод")
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
