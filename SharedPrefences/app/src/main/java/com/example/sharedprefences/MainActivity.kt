package com.example.sharedprefences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences : SharedPreferences
    var usernameAvailable : String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // SharedPreferences dict => key:value

        sharedPreferences = this.getSharedPreferences("com.example.sharedprefences",
            Context.MODE_PRIVATE)

        usernameAvailable = sharedPreferences.getString("username",null)
        if (usernameAvailable != null)
            textView.setText("Welcome MR. ${usernameAvailable}")
        else
            textView.setText("Enter username PLEASE")

    }

    fun save(view:View){
        val username = editText.text.toString()

        if (username == "")
            Toast.makeText(this,"Please Enter Username",Toast.LENGTH_LONG).show()

        else{
            sharedPreferences.edit().putString("username",username).apply()
            Toast.makeText(this,"Username saved succesfully!",Toast.LENGTH_LONG).show()
            textView.setText("Username : "+ username)
        }
    }


    fun delete(view:View){
        usernameAvailable = sharedPreferences.getString("username",null)
        if(usernameAvailable != null){
            textView.text = "removed username : ${usernameAvailable}"
            sharedPreferences.edit().remove("username").apply()
        }

        else
            textView.setText("We cant find any username")

    }
}