package com.vvwxx.rentalpsbe.dto.response

data class PagingBaseResponse<T>(
    val status: String? = null,

    val message: String? = null,

    val page: Int? = null,

    val size: Int? = null,

    val data: T? = null
)
