package com.example.androidapp.shopping

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.androidapp.DataStoreManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ShoppingViewModel(application: Application) : AndroidViewModel(application) {

    private val dataStore = DataStoreManager(application)
    private val _itemList = MutableStateFlow<List<ShoppingData>>(emptyList()) // viewmodel 내부용
    val itemList: StateFlow<List<ShoppingData>> = _itemList
    var fullList: List<ShoppingData> = emptyList()

    init {
        observeItems()
    }

    private fun observeItems() {
        viewModelScope.launch {
            dataStore.getItems().collect { list ->
                fullList = list
                _itemList.value = list
            }
        }
    }

    fun saveItems(items: List<ShoppingData>) {
        viewModelScope.launch {
            dataStore.saveItems(items)
        }
    }

    fun loadItems(context: Context) {
        viewModelScope.launch {
            dataStore.getItems().collect { list ->
                fullList = list
                _itemList.value = list
        }
    }
}}