package com.example.androidapp.data.repository

import com.example.androidapp.data.model.UserData
import com.example.androidapp.data.remote.ReqresApi
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: ReqresApi
) : UserRepository {

    override suspend fun getUser(id: Int): UserData {
        return api.getUser(id).data
    }

    override suspend fun getUserList(page: Int): List<UserData> {
        return api.getUserList(page).data
    }
}