package com.vvwxx.rentalpsbe.service

import com.vvwxx.rentalpsbe.dto.response.ResUser

interface UserService {

    fun getUser(userId: Int): ResUser
}