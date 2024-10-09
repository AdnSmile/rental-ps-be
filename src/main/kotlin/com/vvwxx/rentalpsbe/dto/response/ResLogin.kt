package com.vvwxx.rentalpsbe.dto.response

import com.fasterxml.jackson.annotation.JsonProperty

data class ResLogin(

    @JsonProperty("user_id")
    val userId: Int?,

    val username: String?,

    val email: String?,

    @JsonProperty("no_wa")
    val noWa: String?,

    val role: String?,

    val token: String = "",
)
