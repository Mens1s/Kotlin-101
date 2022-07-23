package com.example.superherobook

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // veri hazirligi

        var superheroNames = ArrayList<String>()

        superheroNames.add("Batman")
        superheroNames.add("Superman")
        superheroNames.add("Iron Man")
        superheroNames.add("Aquaman")
        superheroNames.add("Spiderman")


        // verimsiz Tanimlama
    /*
        val batmanBitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.batman)
        val supermanBitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.superman)
        val ironanBitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.ironman)
        val aquamanBitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.aquaman)
        val spidermanBitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.spiderman)

        var superheroImage = ArrayList<Bitmap>()
        superheroImage.add(batmanBitmap)
        superheroImage.add(supermanBitmap)
        superheroImage.add(ironanBitmap)
        superheroImage.add(aquamanBitmap)
        superheroImage.add(spidermanBitmap)
    */
        // verimli tanimlar
        val batmanDrawableID = R.drawable.batman
        val supermanDrawbleID = R.drawable.superman
        val ironanDrawbleID = R.drawable.ironman
        val aquamanDrawbleID = R.drawable.aquaman
        val spidermanDrawbleID = R.drawable.spiderman

        var superheroImage = ArrayList<Int>()
        superheroImage.add(batmanDrawableID)
        superheroImage.add(supermanDrawbleID)
        superheroImage.add(ironanDrawbleID)
        superheroImage.add(aquamanDrawbleID)
        superheroImage.add(spidermanDrawbleID)

        // adapter
        val layoutmanager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutmanager

        val adapter = RecyclerAdapter(superheroNames, superheroImage)
        recyclerView.adapter = adapter

    }
}