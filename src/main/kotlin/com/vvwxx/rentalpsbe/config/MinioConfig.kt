package com.vvwxx.rentalpsbe.config

import io.minio.MinioClient
import okhttp3.OkHttpClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import java.util.concurrent.TimeUnit

@Component
class MinioConfig(

    @Value("\${minio.baseurl}")
    private val urlMinio: String,

    @Value("\${minio.accessKey}")
    private val accessKey: String,

    @Value("\${minio.secretKey}")
    private val secretKey: String
) {

    @Bean
    fun minioClient(): MinioClient {
        return try {

            // method buat connect, karna pake depedensi ga perlu define urlnya apa
            val httpClient: OkHttpClient = OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.MINUTES)
                .writeTimeout(10, TimeUnit.MINUTES)
                .readTimeout(30, TimeUnit.MINUTES)
                .build()

            MinioClient.builder()
                .endpoint(urlMinio)
                .credentials(accessKey, secretKey)
                .httpClient(httpClient)
                .build()

        } catch (e: Exception) {
            throw RuntimeException(e.message)
        }
    }
}