package com.vvwxx.rentalpsbe.service.impl

import com.vvwxx.rentalpsbe.service.UploadService
import com.vvwxx.rentalpsbe.util.MinioUpload
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class UploadServiceImpl(
    private val minioUpload: MinioUpload,

    @Value("\${minio.mainFolder}")
    val folderMinio: String,

    ) : UploadService {

    override fun uploadFile(file: String, fileName: String, folder: String): String {

        minioUpload.uploadFile(file, fileName, folder)

        return "/$folderMinio/$folder/$fileName.png"
    }
}