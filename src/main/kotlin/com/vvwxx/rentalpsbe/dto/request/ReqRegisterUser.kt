package com.vvwxx.rentalpsbe.dto.request

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size

data class ReqRegisterUser(

    @field:NotEmpty(message = "Field username must not empty")
    @field:NotBlank(message = "Field username must not blank")
    @field:Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Field username must contain only alphabet and numbers")
    val username: String?,

    @field:NotEmpty(message = "Field password must not empty")
    @field:NotBlank(message = "Field password must not blank")
    @field:Size(min = 5, message = "field password size must more than 4")
    val password: String?,

    @field:NotEmpty(message = "Field email must not empty")
    @field:NotBlank(message = "Field email must not blank")
    @field:Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}\$", message = "must include email")
    val email: String?,

    @field:Pattern(regexp = "^[0-9+]*$", message = "Field no_wa must contain only numbers and the '+' symbol")
    @JsonProperty("no_wa")
    val noWa: String?,
)
