package com.example.androidapp

data class ShoppingData(
    val icon: Int,
    val name: String = "",
    val category: String = "",
    val color: String = "",
    val price: String? = "",
    var isLiked: Boolean = false
)