package com.vvwxx.rentalpsbe.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "user")
data class UserEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("user_id")
    val userId: Int? = null,

    var username: String? =null,

    var password: String? =null,

    var email: String? =null,

    @JsonProperty("no_wa")
    var noWa: String? =null,

    var role: String? =null, // owner, admin, customer

    @JsonProperty("created_at")
    val createdAt: Date? = null,

    @JsonProperty("updated_at")
    var updatedAt: Date? = null,

//    @JsonIgnore
//    @OneToMany
//    val reservation: List<>
    )
