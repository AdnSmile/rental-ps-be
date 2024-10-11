package com.vvwxx.rentalpsbe.service.impl

import com.vvwxx.rentalpsbe.dto.response.ResUser
import com.vvwxx.rentalpsbe.entity.UserEntity
import com.vvwxx.rentalpsbe.exception.NotFoundException
import com.vvwxx.rentalpsbe.repository.UserRepository
import com.vvwxx.rentalpsbe.service.UploadService
import com.vvwxx.rentalpsbe.service.UserService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepo: UserRepository,
    private val uploadService: UploadService,
//    private val validationUtil: ValidationUtil
) : UserService {

    override fun getUser(userId: Int): ResUser {

        val user = findByIdCustome(userId)
        return convertUserToResUser(user)
    }

    private fun findByIdCustome(id: Int): UserEntity {
        return userRepo.findByIdOrNull(id) ?: throw NotFoundException("User not found.")
    }

    private fun convertUserToResUser(user: UserEntity): ResUser {
        return ResUser(
            user.userId,
            user.username,
            user.email,
            user.noWa,
            user.role,
            user.createdAt,
            user.createdAt
        )
    }
}