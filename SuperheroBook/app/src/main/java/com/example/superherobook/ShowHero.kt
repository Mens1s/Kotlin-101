package com.example.superherobook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_show_hero.*

class ShowHero : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_hero)

        val intent = intent
        val currHero = intent.getStringExtra("superheroName")
        textView.text = currHero

        val curHeroImg = intent.getIntExtra("superheroIMG",0)
        imageView.setImageResource(curHeroImg)
    /*
        val curHeroImg = singletonClass.currHero.img
        imageView.setImageBitmap(curHeroImg)

     */
    }
}