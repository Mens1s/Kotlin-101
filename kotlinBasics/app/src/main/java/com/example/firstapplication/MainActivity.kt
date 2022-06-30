package com.example.firstapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /* start of variables */

        // integer
        // var variables can be changed
        var a = 5
        var b = 10

        // val variables can not changed
        val nChanged = 6
        val x = 15

        var myInteger : Int = 5
        myInteger = 18

        // Long 2^31 >
        var myLong : Long = 100

        // Double && Float
        val pi = 3.14
        val floatPi : Float = 3.14f
        val doublePi : Double = 3.14

        // String
        val myString = "New Text"

        val name = "Ahmet"
        val surname = "Yigit"
        val fullName = "$name $surname"

        // Boolean
        val myBoolean = true

        // casting
        val ten = 10
        val tenLong = ten.toLong()

        val tenSTR = "10"
        val tenInt = tenSTR.toInt()

        /* end of variables */

        /* arrays */

        /* adding element is permitted WE CANNOT */
        val myArray = arrayOf("Mens1s", "Github",tenSTR)

        //println(myArray[0])
        myArray[0] = "mens1ss"
        //println(myArray[0])     // myArray.get(0) sameThing

        // change variable
        myArray.set(0,"Changed")
        //println(myArray[0])

        var integerArray = doubleArrayOf(1.0,2.0,3.0,5.0)
        val mixArray = arrayOf(1,"ahmet","mixed","array",1.0)
        //println(mixArray[2])
        /* end of arrays */

        /* lists */
        val cList = arrayListOf<String>()

        /* adding element */
        cList.add("mens1s")
        //println(cList)

        /* mixed list */
        val mixList = arrayListOf<Any>()
        mixList.add(2)
        mixList.add("two")
        //println(mixList)

        /* java inheritance */
        val intArrayList = ArrayList<Int>()
        intArrayList.add(1)
        //println(intArrayList)
        /* end of lists */

        /* set */
        /* unique variables list */
        val exArr = arrayOf(7,8,9,9,9,8,10)
        println("index 2 : ${exArr[2]} index 3 : ${exArr[3]} size : ${exArr.size}")

        val setArr = setOf<Int>(7,8,9,9,9,8,10)
        println("size : ${setArr.size} Numbers : ")

        // forEach
        setArr.forEach {
            println(it)
        }

        val otherSet = HashSet<String>()
        otherSet.add("mens1s")
        otherSet.add("mens1s")
        otherSet.add("mens1s")
        otherSet.add("ahmet")

        otherSet.forEach{
            println("Var : $it")
        }
        /* end of set */

        /* map */
        /* dict :D */

        val foodCalMap = hashMapOf<String, Int>()
        foodCalMap.put("Apple", 100)
        foodCalMap.put("Meal", 300)
        foodCalMap.put("Chicken", 200)

        println("Chicken Cal : ${foodCalMap["Chicken"]}")

        val myMap = HashMap<String, String>()
        myMap["ex"] = "ex2"    // you use this way either put

        val newMap = hashMapOf<String, Int>("mens1s" to 30,"ex" to 44)
        println("newMap : ${newMap["ex"]}")

        /* end of maps */

        /* conditional statements */

        val score = 10
        /* if statements */
        if (score < 10)
            println("Lose the game")
        else if (score < 20)
            println("Good job")
        else
            println("YEAH you did it!")

        /* when statements */

        var not = 0
        var notText = ""

        /*
        when(not){
            0 -> notText = "Fail"
            1 -> notText = "Med"
            2 -> notText = "Good"
            else -> notText = "really?"
        }
        */
        notText = when(not){
            0 -> "Fail"
            1 -> "Med"
            2 -> "Good"
            else -> "really?"
        }

        println(notText)

        /* end of statements */

        /* loops */
        val otherInt = arrayOf(5,10,15,20,25,30)
        /* for loop */
        for (a in otherInt.indices){
            otherInt[a] /= 5
        }
        for (b in otherInt){
            println(b)
        }
        /*   forEach loop */
        otherInt.forEach { println(it) }

        /* while loop */
        var j = 0
        while (j < 10){
            println(j)
            j++
        }



    }
}