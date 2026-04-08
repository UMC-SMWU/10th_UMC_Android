package com.example.androidapp.shopping

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.androidapp.DataStoreManager
import kotlinx.coroutines.launch

class ShoppingViewModel(application: Application) : AndroidViewModel(application) {

    private val dataStore = DataStoreManager(application)
    val itemList = MutableLiveData<List<ShoppingData>>()
    var fullList: List<ShoppingData> = emptyList()

    init {
        observeItems()
    }

    private fun observeItems() {
        viewModelScope.launch {
            dataStore.getItems().collect { list ->
                fullList = list
                itemList.postValue(list)
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
                itemList.postValue(list)}
        }
    }
}