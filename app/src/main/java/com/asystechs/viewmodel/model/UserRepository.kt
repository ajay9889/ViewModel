package com.asystechs.viewmodel.model

import kotlinx.coroutines.delay

class UserRepository {
    suspend fun getListOfUser() : List<Users> {
        delay(10000)
        val users :List<Users> = listOf(
        Users(1, "Ajay1"),
        Users(2, "Ajay2"),
        Users(3, "Ajay3"), Users(5, "Ajay5"),
        Users(4, "Ajay4")
        )
        return users
    }
}