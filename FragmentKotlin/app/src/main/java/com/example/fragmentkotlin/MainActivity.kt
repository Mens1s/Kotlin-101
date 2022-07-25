package com.example.fragmentkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun firstFragment(view: View){

        val fragmentmanager = supportFragmentManager
        val fragemntTransaction = fragmentmanager.beginTransaction()

        val firstFragment = BlankFragment()
        fragemntTransaction.replace(R.id.frameLayout, firstFragment).commit()
    }
    fun secondFragment(view: View){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val secondFragment = BlankFragment2()
        fragmentTransaction.replace(R.id.frameLayout, secondFragment).commit()
    }
}