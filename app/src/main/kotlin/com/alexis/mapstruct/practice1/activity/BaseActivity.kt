package com.alexis.mapstruct.practice1.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import practice1.mapstruct.alexis.com.mapstructpractice1.R

abstract class BaseActivity: AppCompatActivity() {
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.actionMainActivity -> launchMyActivity(1)
            R.id.actionSecondActivity -> launchMyActivity(2)
            R.id.actionThirdActivity -> launchMyActivity(3)
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun launchMyActivity(id: Int): Boolean {
        //TODO
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        return true
    }
}