package com.vvwxx.rentalpsbe.repository

import com.vvwxx.rentalpsbe.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<UserEntity, Int> {

    fun getUserEntityByUsername(username: String): UserEntity?

    fun existsByUsername(username: String): Boolean

    fun existsByEmail(email: String): Boolean

    fun getUserEntityByUserId(userId: Int): UserEntity?
}