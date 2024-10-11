package com.vvwxx.rentalpsbe.dto.response

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

data class ResMenu(

    @JsonProperty("menu_id")
    val menuId: Int?,

    @JsonProperty("menu_name")
    var menuName: String?,

    @JsonProperty("menu_type")
    var menuType: String?, // makanan, minuman

    var price: Int?,

    var stock: Int?,

    var image: String? = null,

    @JsonProperty("created_at")
    val createdAt: Date?,

    @JsonProperty("updated_at")
    var updatedAt: Date?,
)
