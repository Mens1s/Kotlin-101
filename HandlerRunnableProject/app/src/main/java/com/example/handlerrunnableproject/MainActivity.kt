package com.example.handlerrunnableproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var num = 0
    var runnable : Runnable = Runnable {    }
    var handler = Handler(Looper.myLooper()!!)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun start(view:View){
        num = 0

        runnable = object : Runnable{
            override fun run() {
                num ++
                textView.setText("Counter : ${num}")
                handler.postDelayed(runnable,1000)
            }

        }
        handler.post(runnable)

    }
    fun stop(view: View){
        handler.removeCallbacks(runnable)
        textView.setText("Counter : 0")
    }
}