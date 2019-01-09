package com.chrhsmt.example.ktor.controllers

import com.chrhsmt.example.ktor.City
import com.chrhsmt.example.ktor.services.CityService
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.locations.get
import io.ktor.response.respond
import io.ktor.routing.Route
import org.apache.http.HttpStatus

fun Route.city(cityService: CityService) {

    get<City> {
        call.respond(cityService.getAllCities())
    }

    get<City.Id> {
        val id = call.parameters["id"]?.toInt()!!
        val city = cityService.getCity(id)
        if (city == null) call.respond(HttpStatusCode.NotFound)
        else call.respond(city)
    }
}