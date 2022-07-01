package com.example.superheroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun makeHero(view : View){
        val name = nameText.text.toString()
        val age = ageText.text.toString().toIntOrNull()
        val job = jobText.text.toString()

        if(age == null){
            textView.text = "Enter number for age!"
        }
        else {
            val userHero = superhero(name, age, job)
            textView.text = "Name: ${userHero.isim}\nAge: ${userHero.yas}\nJob : ${userHero.meslek}"
        }
    }
}