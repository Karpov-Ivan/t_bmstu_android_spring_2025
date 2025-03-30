package models

import interfaces.Returnable

abstract class LibraryItem(
    val id: Int,
    var isAvailable: Boolean,
    val name: String
) : Returnable {

    abstract fun getDetailedInfo(): String

    open fun getShortInfo(): String =
        "$name доступна: ${if (isAvailable) "Да" else "Нет"}"

    override fun returnItem() {
        if (isAvailable) {
            println("Этот объект уже доступен, его нельзя вернуть!")
            return
        }
        isAvailable = true
        println("${this::class.simpleName} $id возвращен")
    }
}