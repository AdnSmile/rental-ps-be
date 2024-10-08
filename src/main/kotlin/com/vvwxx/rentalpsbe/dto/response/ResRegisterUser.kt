package com.vvwxx.rentalpsbe.dto.response

import com.fasterxml.jackson.annotation.JsonProperty

data class ResRegisterUser(

    @JsonProperty("user_id")
    val userId: String?,

    val username: String?,

    val email: String?,

    @JsonProperty("no_wa")
    val noWa: String?,

    val role: String?,

    @JsonProperty("created_at")
    val createdAt: String?,
)
