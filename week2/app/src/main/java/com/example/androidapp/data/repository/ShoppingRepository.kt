package com.example.androidapp.data.repository

import com.example.androidapp.data.model.ShoppingData
import kotlinx.coroutines.flow.Flow

interface ShoppingRepository {

    fun getItems(): Flow<List<ShoppingData>>
    suspend fun saveItems(items: List<ShoppingData>)
    suspend fun initializeDummyData()
}