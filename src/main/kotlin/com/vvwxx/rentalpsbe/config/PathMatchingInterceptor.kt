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
            .excludePathPatterns("/v1/api/menu/{id}")
            .excludePathPatterns("/v1/api/menu/type")

            .excludePathPatterns("/v1/api/ps/{id}")
            .excludePathPatterns("/v1/api/ps/all")
            .excludePathPatterns("/v1/api/ps/type")
            .excludePathPatterns("/v1/api/ps/class")
    }
}