package com.example.basiccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    var res = doubleArrayOf(-1.0,-1.0)
    var flag = 0
    fun cont(){
        val n1 = num1.text.toString().toDoubleOrNull()
        val n2 = num2.text.toString().toDoubleOrNull()

        if(n1 == null || n2 == null){
            resultText.text = "Enter number Please!"
            flag = 1
        }
        else{
            res[0] = n1
            res[1] = n2
        }
    }
    fun mult(view: View){
        cont()
        if(flag == 0)
            resultText.text = "Result : ${res[0]*res[1]}"
    }
    fun div(view: View){
        cont()
        if(flag == 0)
            resultText.text = "Result : ${res[0]/res[1]}"
    }
    fun min(view: View){
        cont()
        if(flag == 0)
            resultText.text = "Result : ${res[0]-res[1]}"
    }
    fun ad(view: View){
        cont()
        if(flag == 0)
            resultText.text = "Result : ${res[0]+res[1]}"
    }
}