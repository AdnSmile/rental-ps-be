package com.vvwxx.rentalpsbe.dto.request

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.PositiveOrZero

data class ReqMenu (

    @field:NotEmpty(message = "field menu_name must not empty")
    @field:NotBlank(message = "field menu_name must not blank")
    @field:Pattern(regexp = "^[a-zA-Z ]*$", message = "Field menu_name must contain only alphabet letters")
    @JsonProperty("menu_name")
    val menuName: String? = null,

    @field:NotEmpty(message = "field menu_type must not empty")
    @field:NotBlank(message = "field menu_type must not blank")
    @field:Pattern(regexp = "^(Makanan|Minuman)$", message = "Field must contain either 'Makanan' or 'Minuman'")
    @JsonProperty("menu_type")
    val menuType: String? = null, // makanan, minuman

    @field:PositiveOrZero(message = "field price is must >= 0")
    val price: Int? = null,

    @field:PositiveOrZero(message = "field stock is must >= 0")
    val stock: Int? = null,

    val image: String? = null,

)