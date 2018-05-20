package com.alexis.mapstruct.practice1.activity

import android.os.Bundle
import android.support.design.widget.Snackbar
import com.alexis.mapstruct.practice1.models.Person
import com.alexis.mapstruct.practice1.mappers.PersonMapper
import kotlinx.android.synthetic.main.activity_main.*
import practice1.mapstruct.alexis.com.mapstructpractice1.R

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val person = Person("Alexis", "Azanza", null)
        val personDto = PersonMapper.INSTANCE.personToPersonDto(person)

        fab.setOnClickListener { view ->
            Snackbar.make(view, personDto.name + personDto.lastName, Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }


}
