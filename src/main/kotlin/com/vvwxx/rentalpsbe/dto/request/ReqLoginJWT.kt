package com.vvwxx.rentalpsbe.dto.request

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty

data class ReqLoginJWT(

    @field:NotEmpty(message = "field user_name must not empty")
    @field:NotBlank(message = "field user_name must not blank")
    val username: String? = null,

    @field:NotEmpty(message = "field password must not empty")
    @field:NotBlank(message = "field password must not blank")
    val password: String? = null,
)
