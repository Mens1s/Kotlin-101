package com.example.classandfunctions

//                  primary Constructor
class Superhero (var isim:String, var yas: Int, var meslek:String) {

    fun testFunc(){
        println("TEst funct")
    }
    private var hairColor = "red"

    //getter
    fun haircolorGET() : String{
        return hairColor
    }

    // access levels
    // private - protected - internal - public

    // private => access only class in defined
    // protected => same file different class can be access
    // internal => only module
    // public => access everywhere

    // final => cannot change but access everywhere
/*
    var isim = ""
    var yas = 0
    var meslek = ""

    // constructor
    // def __init__(self)  self => this

    constructor(isim : String, yas: Int, meslek:String){
        this.isim = isim
        this.yas = yas
        this.meslek = meslek

        println("Constructor called")
    }
*/

}