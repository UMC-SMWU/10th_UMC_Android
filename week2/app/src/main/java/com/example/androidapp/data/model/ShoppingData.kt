package com.example.androidapp.data.model

data class ShoppingData(
    val id: Long,
    val icon: Int,
    val name: String = "",
    val category: String = "",
    val color: String = "",
    val price: String? = "",
    var isLiked: Boolean = false
)