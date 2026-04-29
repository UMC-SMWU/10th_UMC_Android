package com.example.androidapp

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore
import androidx.datastore.preferences.core.*
import com.example.androidapp.shopping.ShoppingData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore(name = "shopping_prefs")

class DataStoreManager(private val context: Context) {

    private val gson = Gson()

    companion object {
        val ITEM_LIST_KEY = stringPreferencesKey("item_list")
    }

    // 리스트 저장
    suspend fun saveItems(items: List<ShoppingData>) {
        val json = gson.toJson(items)

        context.dataStore.edit {
            it[ITEM_LIST_KEY] = json
        }
    }

    // 리스트 불러오기
    fun getItems(): Flow<List<ShoppingData>> {
        return context.dataStore.data.map { preferences ->
            val json = preferences[ITEM_LIST_KEY] ?: "[]"
            val type = object : TypeToken<List<ShoppingData>>() {}.type
            gson.fromJson(json, type)
        }
    }
}