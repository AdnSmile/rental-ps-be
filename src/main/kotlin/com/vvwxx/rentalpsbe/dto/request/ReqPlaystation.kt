package com.vvwxx.rentalpsbe.dto.request

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.PositiveOrZero

data class ReqPlaystation (

    @field:NotEmpty(message = "field ps_id must not empty")
    @field:NotBlank(message = "field ps_id must not blank")
    @field:Pattern(regexp = "^[0-9]{2}$", message = "Field must contain 2 digits of numbers")
    @JsonProperty("ps_id")
    val psId: String?,

    @field:NotEmpty(message = "field ps_class must not empty")
    @field:NotBlank(message = "field ps_class must not blank")
    @field:Pattern(regexp = "^(vip|general)$", message = "Field must contain either 'vip' or 'general'")
    @JsonProperty("ps_class")
    var psClass: String?, // general, vip

    @field:NotEmpty(message = "field ps_class must not empty")
    @field:NotBlank(message = "field ps_class must not blank")
    @field:Pattern(regexp = "^(available|is use|maintenance|reserved)$", message = "Field must contain 'available', 'is use', 'maintenance' or 'reserved'")
    var status: String?, // available, is use, maintenance, reserved

    @field:NotEmpty(message = "field ps_type must not empty")
    @field:NotBlank(message = "field ps_type must not blank")
    @JsonProperty("ps_type")
    var psType: String?,

    @field:PositiveOrZero(message = "field hourly_rate is must >= 0")
    @JsonProperty("hourly_rate")
    var hourlyRate: Int?,
)