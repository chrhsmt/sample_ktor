package com.chrhsmt.example.ktor.services

import com.chrhsmt.example.ktor.model.Cities
import com.chrhsmt.example.ktor.model.City
import com.chrhsmt.example.ktor.services.DatabaseFactory.dbQuery
import org.jetbrains.exposed.sql.*

class CityService {

    suspend fun getAllCities(): List<City> = dbQuery {
        Cities.selectAll().map { toCity(it) }
    }

    suspend fun getCity(id: Int): City? = dbQuery {
        Cities.select {
            (Cities.id eq id)
        }.mapNotNull { toCity(it) }.singleOrNull()
    }

    private fun toCity(row: ResultRow): City =
        City(id = row[Cities.id].value, name = row[Cities.name])
}