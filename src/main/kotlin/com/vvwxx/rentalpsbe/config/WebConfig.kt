package com.vvwxx.rentalpsbe.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig : WebMvcConfigurer {

    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**") // Mengizinkan semua endpoint
            .allowedOrigins("http://localhost:5173") // Mengizinkan asal tertentu (React)
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Mengizinkan metode HTTP tertentu
            .allowedHeaders("*") // Mengizinkan semua header
            .allowCredentials(true) // Mengizinkan cookies atau otentikasi berbasis sesi
    }
}