package com.vvwxx.rentalpsbe.controller

import com.vvwxx.rentalpsbe.dto.response.BaseResponse
import com.vvwxx.rentalpsbe.service.UserService
import com.vvwxx.rentalpsbe.util.JWTGenerator
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/api/user")
class UserController(
    private val userService: UserService
) {

    @GetMapping
    fun getUser(@RequestHeader("token") token: String): ResponseEntity<Any> {

        val user = JWTGenerator().decodeJWT(token)
        val id = user["id"].toString()

        return ResponseEntity.status(HttpStatus.OK).body(
            BaseResponse(
                message = "Successfully get user data",
                status = "T",
                data = userService.getUser(Integer.parseInt(id))
            )
        )
    }
}