package com.alexis.mapstruct.practice1.mappers

import com.alexis.mapstruct.practice1.models.Address
import com.alexis.mapstruct.practice1.models.AddressDto
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

@Mapper()
public interface AddressMapper {
    companion object {
        val INSTANCE: AddressMapper = Mappers.getMapper(AddressMapper::class.java)
}

    fun addressToAddressDto(address: Address): AddressDto
}