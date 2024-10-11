package com.vvwxx.rentalpsbe.service

interface UploadService {

    fun uploadFile(file: String, fileName: String, folder: String): String
}