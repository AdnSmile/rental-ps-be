package com.vvwxx.rentalpsbe.dto.request

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.PositiveOrZero

data class ReqMenu (

    @field:NotEmpty(message = "field menu_name must not empty")
    @field:NotBlank(message = "field menu_name must not blank")
    @JsonProperty("menu_name")
    val menuName: String? = null,

    @field:NotEmpty(message = "field menu_type must not empty")
    @field:NotBlank(message = "field menu_type must not blank")
    @JsonProperty("menu_type")
    val menuType: String? = null, // makanan, minuman

    @field:PositiveOrZero(message = "field price is must >= 0")
    val price: Int? = null,

    @field:PositiveOrZero(message = "field stock is must >= 0")
    val stock: Int? = null,

    val image: String? = null,

)