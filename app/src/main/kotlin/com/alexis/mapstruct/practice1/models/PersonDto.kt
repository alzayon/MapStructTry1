package com.alexis.mapstruct.practice1.models

data class PersonDto(var name: String,
                     var lastName: String,
                     var address: AddressDto?) {

    var fullName: String? = null

    constructor(): this("Alexis",
                "Default last name",
                null)
}