package com.example.androidapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidapp.UserData
import com.example.androidapp.data.remote.RemoteUserRepository
import com.example.androidapp.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    private val repository: UserRepository = RemoteUserRepository()

    private val _user = MutableStateFlow<UserData?>(null)
    val user: StateFlow<UserData?> = _user

    private val _userList = MutableStateFlow<List<UserData>>(emptyList())
    val userList: StateFlow<List<UserData>> = _userList

    init {
        fetchUser(1)
        fetchUserList(1)
    }

    private fun fetchUser(id: Int) {
        viewModelScope.launch {
            try {
                _user.value = repository.getUser(id)  // Repository에게 요청
            } catch (e: Exception) {
                _user.value = null
            }
        }
    }

    private fun fetchUserList(page: Int) {
        viewModelScope.launch {
            try {
                _userList.value = repository.getUserList(page)  // Repository에게 요청
            } catch (e: Exception) {
                _userList.value = emptyList()
            }
        }
    }
}