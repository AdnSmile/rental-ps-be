package com.vvwxx.rentalpsbe.exception

import com.vvwxx.rentalpsbe.dto.response.BaseResponse
import jakarta.validation.ConstraintViolation
import jakarta.validation.ConstraintViolationException
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
class ErrorHandler {

    @ExceptionHandler(UnauthenticatedException::class)
    fun unauthenticatedFound(exception: UnauthenticatedException): ResponseEntity<BaseResponse<Any>> {

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(
            BaseResponse(
                message = exception.message,
                status = "F",
                data = null
            )
        )
    }

    @ExceptionHandler(NotFoundException::class)
    fun notFound(notFoundException: NotFoundException): ResponseEntity<BaseResponse<Any>> {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            BaseResponse(
                message = notFoundException.message,
                status = "F",
                data = null
            )
        )
    }

    @ExceptionHandler(IllegalStateException::class)
    fun ilegal(notFoundException: IllegalStateException): ResponseEntity<BaseResponse<Any>> {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            BaseResponse(
                message = notFoundException.message,
                status = "F",
                data = null
            )
        )
    }

    @ExceptionHandler(DuplicateException::class)
    fun duplicate(exception: DuplicateException): ResponseEntity<BaseResponse<Any>> {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
            BaseResponse(
                message = exception.message,
                status = "F",
                data = null
            )
        )
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationExceptions(ex: MethodArgumentNotValidException): ResponseEntity<BaseResponse<Any>> {

        val errors = ex.bindingResult.allErrors
            .map { (it as FieldError).field + ": " + it.defaultMessage }
            .joinToString(", ")

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
            BaseResponse(
                message = errors,
                status = "F",
                data = null
            )
        )
    }

    @ExceptionHandler(ConstraintViolationException::class)
    fun handleConstraintViolation(exception: ConstraintViolationException): ResponseEntity<BaseResponse<Any>> {

        val errors = exception.constraintViolations
            .joinToString(", ") { violation: ConstraintViolation<*> -> "${violation.propertyPath}: ${violation.message}" }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
            BaseResponse(
                message = errors,
                status = "F",
                data = null
            )
        )
    }
}