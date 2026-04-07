package com.example.androidapp

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.google.gson.Gson
import com.example.androidapp.DataStoreManager


class ShoppingViewModel(application: Application) : AndroidViewModel(application) {

    private val dataStore = DataStoreManager(application)
    val itemList = MutableLiveData<List<ShoppingData>>()
    private val gson = Gson()


    fun saveItems(items: List<ShoppingData>) {
        viewModelScope.launch {
            dataStore.saveItems(items)
        }
    }

    fun loadItems(context: Context) {
        viewModelScope.launch {
            dataStore.getItems().collect { list ->
                itemList.postValue(list)}
        }
    }
}