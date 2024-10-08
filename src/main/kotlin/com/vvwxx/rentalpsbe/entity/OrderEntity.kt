package com.vvwxx.rentalpsbe.entity

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "order")
data class OrderEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("user_id")
    val orderId: Int? = null,

    @JsonProperty("customer_id")
    var customerId: Int? = null,

    @JsonProperty("ps_id")
    var psId: Int? = null,

    @JsonProperty("total_price")
    var totalPrice: Long? = null,

    @JsonProperty("payment_method")
    var paymentMethod: String? = null, // cash, qris, ewallet, card

    @JsonProperty("payment_status")
    var paymentStatus: String? = null, // pending, paid, failed

    @JsonProperty("order_time")
    var orderTime: Date? = null,
)