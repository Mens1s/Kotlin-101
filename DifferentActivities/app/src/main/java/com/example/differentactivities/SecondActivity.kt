package com.example.differentactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val intent = intent
        val name = intent.getStringExtra("send")
        textView2.text = "Your Name is ${name}"
    }

    fun returnPage(view: View){
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
    }
}