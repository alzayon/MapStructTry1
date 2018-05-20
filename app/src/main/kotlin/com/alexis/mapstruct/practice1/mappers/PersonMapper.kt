package com.alexis.mapstruct.practice1.mappers

import com.alexis.mapstruct.practice1.models.Person
import com.alexis.mapstruct.practice1.models.PersonDto
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Qualifier
import org.mapstruct.factory.Mappers
import org.mapstruct.MappingTarget
import org.mapstruct.AfterMapping
import org.mapstruct.BeforeMapping
import timber.log.Timber


@Mapper(uses = arrayOf(AddressMapper::class, PersonMapperUtil::class))
public abstract class PersonMapper {
    companion object {
        val INSTANCE: PersonMapper = Mappers.getMapper(PersonMapper::class.java)
    }

    @Mapping(source = "name", target = "fullName", qualifiedBy = arrayOf(MapStructQualifierFullName::class))
    abstract fun personToPersonDto(person: Person): PersonDto

    @BeforeMapping
    protected fun beforeOperation(person: Person) {
        // I would call my entity manager's flush() method here to make sure my entity
        // is populated with the right @Version before I let it map into the DTO
        Timber.d("Person is " + person)
    }

    @AfterMapping
    protected fun afterOperation(person: Person, @MappingTarget personDto: PersonDto) {
        personDto.fullName = ":::" + personDto.fullName + ":::"
    }

}

@Qualifier
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.SOURCE)
annotation class MapStructQualifierFullName

class PersonMapperUtil {

    @MapStructQualifierFullName
    fun mapFullName(name: String?): String {
        //Custom logic
        return "the full name"
    }
}