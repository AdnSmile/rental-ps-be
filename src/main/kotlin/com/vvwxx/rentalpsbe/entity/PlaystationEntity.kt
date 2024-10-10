package com.vvwxx.rentalpsbe.entity

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "playstation")
data class PlaystationEntity(

    @Id
    @JsonProperty("ps_id")
    val psId: String? = null,

    @JsonProperty("ps_class")
    var psClass: String? = null, // general, vip

    @JsonProperty("ps_type")
    var psType: String? = null,

    var status: String? = null, // available, is use, maintenance, Reserved

    @JsonProperty("hourly_rate")
    var hourlyRate: Int? = null,

    @JsonProperty("created_at")
    var createdAt: Date? = null,

    @JsonProperty("updated_at")
    var updatedAt: Date? = null,
)
