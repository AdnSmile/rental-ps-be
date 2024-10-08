package com.vvwxx.rentalpsbe.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.vvwxx.rentalpsbe.dto.response.BaseResponse
import com.vvwxx.rentalpsbe.util.JWTGenerator
import io.jsonwebtoken.ExpiredJwtException
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor

@Component
class AuthInterceptor: HandlerInterceptor {

    override  fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {

        val token = request.getHeader("token")

        if (token == null) {

            val body: BaseResponse<String> = BaseResponse(
                status = "401",
                message = "You don't have permission",
                data = null
            )
            internalServerError(body, response)
            return false
        }

        try {
            JWTGenerator().decodeJWT(token).get("id".toString()) ?: RuntimeException("Invalid JWT token")
        } catch (e: ExpiredJwtException) {

            e.printStackTrace()
            val body: BaseResponse<String> = BaseResponse(message = "Invalid token", data = null)

            internalServerError(body, response)

            return false
        }

        return super.preHandle(request, response, handler)
    }

    fun internalServerError(
        body: BaseResponse<String>,
        response: HttpServletResponse
    ): HttpServletResponse {

        response.status = HttpStatus.FORBIDDEN.value()
        response.contentType = "application/json"
        response.writer.write(convertObjectToJson(body))
        return response
    }

    fun convertObjectToJson(dto: BaseResponse<String>): String {

        return ObjectMapper().writeValueAsString(dto)
    }
}