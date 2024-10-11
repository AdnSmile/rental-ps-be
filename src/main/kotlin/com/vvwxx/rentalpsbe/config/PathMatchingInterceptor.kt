package com.vvwxx.rentalpsbe.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class PathMatchingInterceptor(
    val authInterceptor: AuthInterceptor
) : WebMvcConfigurer {

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(authInterceptor)
            .excludePathPatterns("/v1/api/login")
            .excludePathPatterns("/v1/api/register")
            .excludePathPatterns("/v1/api/menu/all")
            .excludePathPatterns("/v1/api/menu/{menu_type}")
    }
}