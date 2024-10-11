package com.vvwxx.rentalpsbe.service.impl

import com.vvwxx.rentalpsbe.dto.request.ReqLoginJWT
import com.vvwxx.rentalpsbe.dto.request.ReqRegisterUser
import com.vvwxx.rentalpsbe.dto.response.ResLogin
import com.vvwxx.rentalpsbe.dto.response.ResRegisterUser
import com.vvwxx.rentalpsbe.entity.UserEntity
import com.vvwxx.rentalpsbe.exception.DuplicateException
import com.vvwxx.rentalpsbe.exception.NotFoundException
import com.vvwxx.rentalpsbe.repository.UserRepository
import com.vvwxx.rentalpsbe.service.AuthService
import com.vvwxx.rentalpsbe.service.UploadService
import com.vvwxx.rentalpsbe.util.JWTGenerator
import com.vvwxx.rentalpsbe.util.Util
import com.vvwxx.rentalpsbe.validation.ValidationUtil
import org.mindrot.jbcrypt.BCrypt
import org.springframework.stereotype.Service
import java.util.*

@Service
class AuthServiceImpl(
    private val repo: UserRepository,
    private val validationUtil: ValidationUtil,
    private val uploadService: UploadService,
) : AuthService {

    override fun register(req: ReqRegisterUser): ResRegisterUser {


        validationUtil.validate(req)

        if (repo.existsByUsername(req.username!!)) {
            throw DuplicateException("Username already exists")
        }

        if (repo.existsByEmail(req.email!!)) {
            throw DuplicateException("Email already exists")
        }

        val imgUrl = if (req.image?.isNotEmpty() == true) {
            uploadService.uploadFile(
                req.image!!,
                fileName = Util.filePath(req.username.replace(" ", "_")),
                folder = "users"
            )
        } else {
            null
        }

        val user = UserEntity(
            username = req.username,
            password = BCrypt.hashpw(req.password, BCrypt.gensalt()),
            email = req.email,
            noWa = req.noWa,
            role = "Customer",
            image = imgUrl,
            createdAt = Date(),
            updatedAt = null,
        )

        repo.save(user)

        return ResRegisterUser(
            username = user.username,
            email = user.email,
            noWa = user.noWa,
            role = user.role,
            image = imgUrl,
            createdAt = user.createdAt
        )
    }

    override fun login(req: ReqLoginJWT): ResLogin {

        validationUtil.validate(req)

        val userExists = repo.getUserEntityByUsername(req.username!!)

        if (userExists == null) {
            throw NotFoundException("Username or password is incorrect")
        } else {

            if (!BCrypt.checkpw(req.password, userExists.password)) {
                throw DuplicateException("Username or password is incorrect")
            }

            return ResLogin(
                userId = userExists.userId,
                username = userExists.username,
                email = userExists.email,
                noWa = userExists.noWa,
                role = userExists.role,
                token = JWTGenerator().createJWT(userExists)
            )
        }
    }
}