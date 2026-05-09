package com.example.androidapp.data.repository

import com.example.androidapp.data.model.UserData

interface UserRepository {
    suspend fun getUser(id: Int): UserData
    suspend fun getUserList(page: Int): List<UserData>
}
