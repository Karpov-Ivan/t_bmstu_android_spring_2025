import java.util.Scanner

// Базовый класс для объектов библиотеки
abstract class LibraryItem(val id: Int, var isAvailable: Boolean, val name: String) {
    abstract fun getDetailedInfo(): String
    open fun getShortInfo(): String = "$name доступна: ${if (isAvailable) "Да" else "Нет"}"
}

// Класс для книг
class Book(id: Int, isAvailable: Boolean, name: String, val pages: Int, val author: String) : LibraryItem(id, isAvailable, name) {
    override fun getDetailedInfo(): String = "Книга: $name ($pages стр.) автора: $author с id: $id доступна: ${if (isAvailable) "Да" else "Нет"}"
}

// Класс для газет
class Newspaper(id: Int, isAvailable: Boolean, name: String, val issueNumber: Int) : LibraryItem(id, isAvailable, name) {
    override fun getDetailedInfo(): String = "Выпуск: $issueNumber газеты $name с id: $id доступен: ${if (isAvailable) "Да" else "Нет"}"
}

// Класс для дисков
class Disk(id: Int, isAvailable: Boolean, name: String, val type: String) : LibraryItem(id, isAvailable, name) {
    override fun getDetailedInfo(): String = "$type $name доступен: ${if (isAvailable) "Да" else "Нет"}"
}

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
            1 -> takeHome(item)
            2 -> readInLibrary(item)
            3 -> println(item.getDetailedInfo())
            4 -> returnItem(item)
            5 -> return
            else -> println("Неверный ввод")
        }
    }
}

fun takeHome(item: LibraryItem) {
    if (item !is Book && item !is Disk) {
        println("Нельзя взять этот объект домой!")
        return
    }
    if (!item.isAvailable) {
        println("Этот объект уже занят!")
        return
    }
    item.isAvailable = false
    println("${item::class.simpleName} ${item.id} взят домой")
}

fun readInLibrary(item: LibraryItem) {
    if (item !is Book && item !is Newspaper) {
        println("Этот объект нельзя читать в зале!")
        return
    }
    if (!item.isAvailable) {
        println("Этот объект уже занят!")
        return
    }
    item.isAvailable = false
    println("${item::class.simpleName} ${item.id} взят в читальный зал")
}

fun returnItem(item: LibraryItem) {
    if (item.isAvailable) {
        println("Этот объект уже доступен, его нельзя вернуть!")
        return
    }
    item.isAvailable = true
    println("${item::class.simpleName} ${item.id} возвращен")
}