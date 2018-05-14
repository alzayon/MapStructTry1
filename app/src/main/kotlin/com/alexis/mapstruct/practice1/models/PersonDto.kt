package com.alexis.mapstruct.practice1.models

data class PersonDto(var name: String, var lastName: String) {
    constructor(): this("Alexis", "Default last name") {
    }
}