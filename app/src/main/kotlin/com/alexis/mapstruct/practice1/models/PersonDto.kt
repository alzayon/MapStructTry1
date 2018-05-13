package com.alexis.mapstruct.practice1.models

data class PersonDto(var name: String) {
    constructor(): this("Alexis") {
    }
}