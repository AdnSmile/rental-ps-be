package com.vvwxx.rentalpsbe.entity

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "menu")
data class MenuEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("menu_id")
    val menuId: Int? = null,

    @JsonProperty("menu_name")
    var menuName: String? = null,

    @JsonProperty("menu_type")
    var menuType: String? = null, // makanan, minuman

    var price: Int? = null,

    var stock: Int? = null,

    @JsonProperty("created_at")
    var createdAt: Date? = null,

    @JsonProperty("updated_at")
    var updatedAt: Date? = null,
)
