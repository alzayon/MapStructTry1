package com.alexis.mapstruct.practice1.models

data class AddressDto(var street: String, var unit: String) {
    constructor(): this("street", "unit")
}