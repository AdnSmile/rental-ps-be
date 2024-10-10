package com.vvwxx.rentalpsbe.dto.request

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.PositiveOrZero

data class ReqPlaystation (

    @field:NotEmpty(message = "field ps_id must not empty")
    @field:NotBlank(message = "field ps_id must not blank")
    @field:Pattern(regexp = "^[0-9]{2}$", message = "Field must contain 2 digits")
    @JsonProperty("ps_id")
    val psId: String?,

    @field:NotEmpty(message = "field ps_class must not empty")
    @field:NotBlank(message = "field ps_class must not blank")
    @JsonProperty("ps_class")
    var psClass: String?, // general, vip

    @field:NotEmpty(message = "field ps_class must not empty")
    @field:NotBlank(message = "field ps_class must not blank")
    var status: String?, // available, is use, maintenance, Reserved

    @field:NotEmpty(message = "field ps_type must not empty")
    @field:NotBlank(message = "field ps_type must not blank")
    @JsonProperty("ps_type")
    var psType: String?,

    @field:NotEmpty(message = "field hourly_rate must not empty")
    @field:NotBlank(message = "field hourly_rate must not blank")
    @field:PositiveOrZero(message = "field hourly_rate is must >= 0")
    @JsonProperty("hourly_rate")
    var hourlyRate: Int?,
)