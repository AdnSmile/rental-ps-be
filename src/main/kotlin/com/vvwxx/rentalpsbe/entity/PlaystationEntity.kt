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
    var psType: String? = null, // available, is use, maintenance, Reserved

    @JsonProperty("hourlyRate")
    var hourlyRate: Int? = null,

    @JsonProperty("created_at")
    val createdAt: Date? = null,

    @JsonProperty("updated_at")
    var updatedAt: Date? = null,
)
