package com.vvwxx.rentalpsbe.dto.response

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

data class ResPlaystation(

    @JsonProperty("ps_id")
    val psId: String?,

    @JsonProperty("ps_class")
    var psClass: String?, // general, vip

    @JsonProperty("ps_type")
    var psType: String?,

    var status: String?, // available, is use, maintenance, Reserved

    @JsonProperty("hourly_rate")
    var hourlyRate: Int?,

    @JsonProperty("created_at")
    val createdAt: Date?,

    @JsonProperty("updated_at")
    var updatedAt: Date?,
)
