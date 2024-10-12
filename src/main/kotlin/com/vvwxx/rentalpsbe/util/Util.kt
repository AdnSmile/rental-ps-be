package com.vvwxx.rentalpsbe.util

import java.text.SimpleDateFormat
import java.util.*

object Util {

    fun filePath(name: String): String {

        return "${SimpleDateFormat("yyyyMMddHHmmss").format(Date())}_$name"
    }

    fun actualPageValue(page: Int): Int {
        return if (page != 0) {
            page - 1
        } else {
            page
        }
    }
}