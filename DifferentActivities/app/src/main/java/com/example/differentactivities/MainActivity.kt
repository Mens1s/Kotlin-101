package com.example.differentactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("Called onCreate")

    }

    override fun onStart() {
        super.onStart()
        println("Called onStart")

    }

    override fun onResume() {
        super.onResume()
        println("Called onResume")

    }

    override fun onPause() {
        super.onPause()
        println("Called onPause")

    }

    override fun onStop() {
        super.onStop()
        println("Called onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("Called onDestroy")

    }
    fun changeActivity(view: View){

        val name = editText.text.toString()

        val intent = Intent(applicationContext, SecondActivity::class.java)
        intent.putExtra("send", name)
        startActivity(intent)
        finish()
    }
}