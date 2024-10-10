package com.vvwxx.rentalpsbe.dto.response

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

data class ResUser(
    @JsonProperty("user_id")
    val userId: Int?,

    var username: String?,

    var email: String?,

    @JsonProperty("no_wa")
    var noWa: String?,

    var role: String?, // owner, admin, customer

    @JsonProperty("created_at")
    val createdAt: Date?,

    @JsonProperty("updated_at")
    var updatedAt: Date?,
)
