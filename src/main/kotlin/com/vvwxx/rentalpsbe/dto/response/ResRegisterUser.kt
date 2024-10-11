package com.vvwxx.rentalpsbe.dto.response

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Date

data class ResRegisterUser(

    val username: String?,

    val email: String?,

    @JsonProperty("no_wa")
    val noWa: String?,

    val role: String?,

    val image: String?,

    @JsonProperty("created_at")
    val createdAt: Date?,
)
