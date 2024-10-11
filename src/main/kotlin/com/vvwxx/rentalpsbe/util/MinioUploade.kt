package com.vvwxx.rentalpsbe.util

import io.minio.MinioClient
import io.minio.RemoveObjectArgs
import io.minio.UploadObjectArgs
import jakarta.xml.bind.DatatypeConverter
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.io.BufferedOutputStream
import java.io.File
import java.io.FileOutputStream

@Component
class MinioUpload (

    private val minioClient: MinioClient,

    @Value("\${minio.bucket}")
    val bucket: String,

    @Value("\${minio.mainFolder}")
    val mainFolder: String
) {

    fun uploadFile(file: String, fileName: String, fullPath: String) {

        val data = DatatypeConverter.parseBase64Binary(file)
        val file = File(fileName)

        try {
            val outputStream = BufferedOutputStream(FileOutputStream(file))
            outputStream.write(data)

            if (!file.exists()) {
                outputStream.close()
                if (file.delete()) println("Deleted File")
            }

            val bytes = file.length().toFloat()
            val megaBytes: Float = (bytes / 1024) / 1024

            if (megaBytes > 2) {
                outputStream.close()
                if (file.delete()) println("Deleted File")
            }

            val uploadObjectArgs: UploadObjectArgs =
                UploadObjectArgs.builder()
                    .bucket(bucket)
                    .`object`("$mainFolder/$fullPath/$fileName.png")
                    .filename(fileName)
                    .contentType("image/png")
                    .build()

            minioClient.uploadObject(uploadObjectArgs)
            outputStream.close()
            if (file.delete()) println("Deleted File")

        } catch (e: Exception) {
            throw RuntimeException(e.message)
        }
    }

    fun deleteFile(path: String) {
        val deleteObject = RemoveObjectArgs.builder().bucket(bucket).`object`(path).build()
        minioClient.removeObject(deleteObject)
    }
}