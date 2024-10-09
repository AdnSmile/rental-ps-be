package com.vvwxx.rentalpsbe.service

import com.vvwxx.rentalpsbe.dto.request.ReqLoginJWT
import com.vvwxx.rentalpsbe.dto.request.ReqRegisterUser
import com.vvwxx.rentalpsbe.dto.response.ResLogin
import com.vvwxx.rentalpsbe.dto.response.ResRegisterUser

interface AuthService {

    fun register(req: ReqRegisterUser): ResRegisterUser

    fun login(req: ReqLoginJWT): ResLogin
}