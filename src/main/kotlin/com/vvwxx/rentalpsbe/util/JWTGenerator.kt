package com.vvwxx.rentalpsbe.util

import com.vvwxx.rentalpsbe.entity.UserEntity
import io.jsonwebtoken.Claims
import io.jsonwebtoken.JwtBuilder
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import jakarta.xml.bind.DatatypeConverter
import org.slf4j.LoggerFactory
import java.util.*
import javax.crypto.spec.SecretKeySpec

class JWTGenerator {

    companion object {
        val key = "FE9DB4AF2A9DF6234D12C71F787128CF53C6278C0C8BB2FDEFD2A71954D5589D"
        private val instance: JWTGenerator = JWTGenerator()
    }

    val log = LoggerFactory.getLogger(this::class.java)

    fun createJWT(req: UserEntity): String {

        println("KEY : $key")

        val signatureAlgorithm: SignatureAlgorithm = SignatureAlgorithm.HS256
        val nowMills: Long = System.currentTimeMillis()
        val now = Date(nowMills)

        val apiKeySecurityByte = DatatypeConverter.parseBase64Binary(key)
        val signingKey = SecretKeySpec(apiKeySecurityByte, signatureAlgorithm.jcaName)

        val builder: JwtBuilder = Jwts.builder().setSubject(req.username)
            .claim("id", req.userId.toString())
            .claim("username", req.username)
            .claim("email", req.email)
            .claim("noWa", req.noWa)
            .claim("role", req.role)
            .setIssuedAt(now)
            .setIssuer("vvwxx")
            .setAudience("vvwxx")
            .signWith(signatureAlgorithm, signingKey)

        val expMills = nowMills + 2628000000L
        val exp = Date(expMills)
        builder.setExpiration(exp)

        return builder.compact()
    }

    fun decodeJWT(jwt: String): Claims {

        val claims: Claims = Jwts.parser()
            .setSigningKey(DatatypeConverter.parseBase64Binary(key))
            .parseClaimsJws(jwt).body

        log.info("ID : ${claims.id}")
        log.info("Issue: ${claims.issuer}")
        log.info("Subject: ${claims.subject}")
        return claims
    }
}