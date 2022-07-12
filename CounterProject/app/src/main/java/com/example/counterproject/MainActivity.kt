package com.example.counterproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // abstract class
        // we can't create object from abstract class

        object : CountDownTimer(15000,1000){
            override fun onFinish() {
                textView.text = "FINISHED"

            }
            override fun onTick(p0: Long) {

                textView.text = "TikTak : ${p0/1000}"
            }

        }.start()
    }
}