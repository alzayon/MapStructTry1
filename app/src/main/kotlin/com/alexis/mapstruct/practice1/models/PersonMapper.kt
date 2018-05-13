package com.alexis.mapstruct.practice1.models

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.ReportingPolicy
import org.mapstruct.factory.Mappers

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface PersonMapper {
    companion object {
        val INSTANCE: PersonMapper = Mappers.getMapper(PersonMapper::class.java)
    }

    @Mapping(source = "name", target = "name")
    fun personToPersonDto(person: Person): PersonDto
}