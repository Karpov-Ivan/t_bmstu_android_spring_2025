package com.example.t_bmstu_android_spring_2025.utils

inline fun <reified T> List<Any>.filterByType(): List<T> {
    return this.filterIsInstance<T>()
}