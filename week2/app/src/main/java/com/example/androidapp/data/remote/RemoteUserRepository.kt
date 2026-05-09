package com.example.androidapp.data.remote

import com.example.androidapp.data.repository.UserRepository
import com.example.androidapp.data.model.UserData

class RemoteUserRepository : UserRepository {
    override suspend fun getUser(id: Int): UserData {
        return RetrofitClient.api.getUser(id).data
    }

    override suspend fun getUserList(page: Int): List<UserData> {
        return RetrofitClient.api.getUserList(page).data
    }
}