package com.chrhsmt.example.ktor.model

import org.jetbrains.exposed.dao.IntIdTable

object Cities: IntIdTable() {
    val name = varchar("name", 256)
}

data class City(
    val id: Int,
    val name: String
)