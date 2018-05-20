package alexis.mapstruct.practice1.mappers

import com.alexis.mapstruct.practice1.mappers.PersonMapper
import com.alexis.mapstruct.practice1.models.Address
import com.alexis.mapstruct.practice1.models.Person
import junit.framework.Assert
import org.junit.Test

class PersonMapperTest {
    @Test
    fun `test Person to PersonDto mapper`() {
        val person = Person("John", "Doe", null)

        val personDto = PersonMapper.INSTANCE.personToPersonDto(person)

        Assert.assertNotNull(personDto)
        Assert.assertEquals(person.name, personDto.name)
        Assert.assertEquals(person.lastName, personDto.lastName)

        //Custom method mapping
        Assert.assertEquals(":::the full name:::", personDto.fullName)
    }

    @Test
    fun `test Person to PersonDto mapper with Address`() {
        val address = Address("my street", "unit a4")
        val person = Person("John", "Doe", address)

        val personDto = PersonMapper.INSTANCE.personToPersonDto(person)

        Assert.assertNotNull(personDto)
        Assert.assertEquals(person.name, personDto.name)
        Assert.assertEquals(person.lastName, personDto.lastName)
        Assert.assertNotNull(personDto.address)

        val addressDto = personDto.address
        Assert.assertEquals(address.street, addressDto?.street)
        Assert.assertEquals(address.unit, addressDto?.unit)
    }
}