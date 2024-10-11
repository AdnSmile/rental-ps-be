package com.vvwxx.rentalpsbe.util

import java.text.SimpleDateFormat
import java.util.*

object Util {

    fun filePath(name: String): String {

        return "${SimpleDateFormat("yyyyMMddHHmmss").format(Date())}_$name"
    }
}