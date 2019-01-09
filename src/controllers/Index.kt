package com.chrhsmt.example.ktor.controllers

import com.chrhsmt.example.ktor.Index
import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.locations.get
import io.ktor.response.respondText
import io.ktor.routing.Route

fun Route.index() {

    get<Index> {
        call.respondText("HELLO WORLD!", contentType = ContentType.Text.Plain)
    }

}