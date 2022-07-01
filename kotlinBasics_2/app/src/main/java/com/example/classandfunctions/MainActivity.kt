package com.example.classandfunctions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstFunc()
        subtract(10,15)
        var x = add(10,2)
        textView.append("\nResult2 : $x")

        button.setOnClickListener{
            textView.append("\nResult 3 : ${add(20,30)}")
        }
        classStudy()
        nullSec()
    }

    fun firstFunc(){
        println("first func")
    }

    // parameter
    fun subtract(x: Int, y: Int){
        textView.text = "Result1 : ${x-y}"
    }

    // return
    fun add(x:Int, y:Int) : Int{
        return x + y
    }
    /*
    fun degistir(view : View){
        val addRes = add(10,20)
        textView.append("\nResult3 : $addRes")
    }
    */

    fun classStudy(){
        var superman = Superhero("superman",60,"gazateci")

        var batman = Superhero("batman",70,"rich")

        println(superman.isim+superman.meslek + batman.isim+batman.yas)
        batman.testFunc()

        println(batman.haircolorGET())
    }

    // null Security
    fun nullSec(){
        //Null , Nullability, Null Safety

        // defining   => ? can be null
        var myInt : Int? = null

        println(myInt)
        // initialization

        // yontem1
        // null gelebileceği durumlarda bu kontroller sağlanır
        if(myInt != null){
            println(myInt * 2)
        }
        else{
            println("null-1")
        }

        // yontem2
        // null gelmeyeceğinden eminsek
        // !! => null olmayacak  ? => null olabilir

        println(myInt?.minus(2))   //  null yazdirir null gelirse
        myInt = 2
        println(myInt!!.minus(2))  //  uygulama cöker null gelirse

        // yontem3
        // elvis Operatörü
        var myAge : Int? = null

        val sonuc = myAge?.minus(2) ?: 10
        println("Sonuc : $sonuc")

        // yontem4
        myAge = 4
        // eğer null degilse calisir
        myAge?.let {
            println(it * 5)
        }
    }
}