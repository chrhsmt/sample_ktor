package com.chrhsmt.example.ktor.auth

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm

open class SimpleJWT(val secret: String) {
    private val algorithm = Algorithm.HMAC256(secret)
    val verifier = JWT.require(algorithm).build()
    fun sign(name: String): String {
        return JWT.create().withClaim("name", name).sign(algorithm)
    }
}