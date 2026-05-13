package com.example.androidapp.data.repository

import com.example.androidapp.DataStoreManager
import com.example.androidapp.R
import com.example.androidapp.data.model.ShoppingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class ShoppingRepositoryImpl @Inject constructor(
    private val dataStoreManager: DataStoreManager
) : ShoppingRepository {

    private val dummyItems = listOf(

        ShoppingData(
            R.drawable.shopping_item,
            "Nike Everyday Plus Cushioned",
            "Training Ankle Socks (6 Pairs)",
            "5 Colours",
            "US$10"
        ),

        ShoppingData(
            R.drawable.shopping_item,
            "Nike Elite Crew",
            "Basketball Socks",
            "7 Colours",
            "US$16"
        ),

        ShoppingData(
            R.drawable.home_item1,
            "Nike Air Force 1 '07",
            "Women's Shoes",
            "5 Colours",
            "US$115"
        ),

        ShoppingData(
            R.drawable.home_item2,
            "Jordan ENike Air Force 1 '07 essentials",
            "Men's Shoes",
            "2 Colours",
            "US$115"
        )
    )

    override fun getItems(): Flow<List<ShoppingData>> {
        return dataStoreManager.getItems()
    }

    override suspend fun saveItems(items: List<ShoppingData>) {
        dataStoreManager.saveItems(items)
    }

    override suspend fun initializeDummyData() {

        val currentItems = dataStoreManager.getItems().first()

        if (currentItems.isEmpty()) {

            dataStoreManager.saveItems(dummyItems)
        }
    }
}