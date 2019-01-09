package com.chrhsmt.example.ktor

import io.ktor.locations.Location

@Location("/")
class Index()

@Location("/city")
class City() {
    @Location("/{id}")
    data class Id(val id: Int)
}