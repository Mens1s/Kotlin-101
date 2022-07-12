package com.example.contextproject

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Toast, alert

        // applicationContext => App context
        // this, this@MainActivity => Activity context

        // small message from bottom
        Toast.makeText(this , "Welcome !", Toast.LENGTH_LONG).show()

    }

    fun showMessage(view: View){
        val alertMessage = AlertDialog.Builder(this@MainActivity)
        alertMessage.setTitle("Password Wrong!")
        alertMessage.setMessage("No password is entered, Enter password !")
        alertMessage.setPositiveButton("Yes", DialogInterface.OnClickListener { dialogInterface, i ->
            Toast.makeText(this, "You are trying again", Toast.LENGTH_LONG).show()
        })
        alertMessage.setNegativeButton("No"){dialogInterface, i ->
            Toast.makeText(this,"You don't try again mamm",Toast.LENGTH_LONG).show()
        }

        alertMessage.show()
    }
}