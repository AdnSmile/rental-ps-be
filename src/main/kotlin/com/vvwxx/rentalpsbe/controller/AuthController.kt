package com.vvwxx.rentalpsbe.controller

import com.vvwxx.rentalpsbe.dto.request.ReqLoginJWT
import com.vvwxx.rentalpsbe.dto.request.ReqRegisterUser
import com.vvwxx.rentalpsbe.dto.response.BaseResponse
import com.vvwxx.rentalpsbe.service.AuthService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/api")
class AuthController(
    private val authService: AuthService,
) {

    @PostMapping("/register")
    fun registerUser(@RequestBody req: ReqRegisterUser): ResponseEntity<Any> {

        return ResponseEntity.ok(
            BaseResponse(
                message = "Successfully registered user",
                status = "T",
                data = authService.register(req)
            )
        )
    }

    @PostMapping("/login")
    fun login(@RequestBody req: ReqLoginJWT): ResponseEntity<Any> {

        return ResponseEntity.ok(
            BaseResponse(
                message = "Successfully logged in",
                status = "T",
                data = authService.login(req)
            )
        )
    }
}