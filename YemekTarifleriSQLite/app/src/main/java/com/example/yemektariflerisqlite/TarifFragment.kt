package com.example.yemektariflerisqlite

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.PackageManagerCompat
import kotlinx.android.synthetic.main.fragment_tarif.*
import java.lang.Exception
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.navigation.Navigation
import java.io.ByteArrayOutputStream
import kotlin.math.max


class TarifFragment : Fragment() {
    var secilenGorsel : Uri? = null
    var secilenGorselBitmap : Bitmap? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tarif, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button.setOnClickListener{
            kaydet(it)
        }
        imageView.setOnClickListener{
            gorselSec(it)
        }

        arguments?.let {
            var gelenBilgi = TarifFragmentArgs.fromBundle(it).bilgi

            if (gelenBilgi.equals("menudengeldim")){
                yemekismiText.setText("")
                yemekmalzemeText.setText("")
                button.visibility = View.VISIBLE

                val gorselSecmeArkaplani = BitmapFactory.decodeResource(context?.resources, R.drawable.gorselsecimi)
                imageView.setImageBitmap(gorselSecmeArkaplani)
            }else{
                button.visibility = View.INVISIBLE

                val secilenID = TarifFragmentArgs.fromBundle(it).id

                context?.let {
                    try {
                        val db = it.openOrCreateDatabase("Yemekler", Context.MODE_PRIVATE, null)
                        val cursor = db.rawQuery("SELECT * FROM yemekler WHERE id = ?", arrayOf(secilenID.toString()))

                        val yemekIsmiIndex = cursor.getColumnIndex("yemekismi")
                        val yemekMalzemeIndex = cursor.getColumnIndex("yemekmalzemesi")
                        val yemekGorseli = cursor.getColumnIndex("gorsel")

                        while (cursor.moveToNext()){
                            yemekismiText.setText(cursor.getString(yemekIsmiIndex))
                            yemekmalzemeText.setText(cursor.getString(yemekMalzemeIndex))

                            val byteDizisi = cursor.getBlob(yemekGorseli)
                            val bitmap = BitmapFactory.decodeByteArray(byteDizisi,0,byteDizisi.size)
                            imageView.setImageBitmap(bitmap)
                        }
                        cursor.close()
                    }
                    catch (e:Exception){
                        e.printStackTrace()
                    }
                }
            }
        }
    }

    fun kaydet(view: View){
        //sqlite a kaydetme
        val yemekIsmı = yemekismiText.text.toString()
        val yemekMalzemeleri = yemekmalzemeText.text.toString()

        if (secilenGorselBitmap != null){
            val kucukBitmap = kucukBitmapOlusutur(secilenGorselBitmap!!, 300)
            val outputStream = ByteArrayOutputStream()
            kucukBitmap.compress(Bitmap.CompressFormat.PNG, 50,outputStream)
            val byteDizisi = outputStream.toByteArray()

            try {
                context?.let {
                    val database = it.openOrCreateDatabase("Yemekler", Context.MODE_PRIVATE, null)
                    database.execSQL("CREATE TABLE IF NOT EXISTS yemekler (id INTEGER PRIMARY KEY, yemekismi VARCHAR, yemekmalzemesi VARCHAR, gorsel BLOB)")

                    val sqlString = "INSERT INTO yemekler (yemekismi, yemekmalzemesi, gorsel) VALUES (? ,? ,? )"
                    val statement = database.compileStatement(sqlString)

                    statement.bindString(1,yemekIsmı)
                    statement.bindString(2,yemekMalzemeleri)
                    statement.bindBlob(3,byteDizisi)
                    statement.execute()
                }

            }catch (e:Exception){
                e.printStackTrace()
            }

            val action = TarifFragmentDirections.actionTarifFragmentToListeFragment()
            Navigation.findNavController(view).navigate(action)

        }
    }

    fun gorselSec(view: View){
        activity?.let {
            if (ContextCompat.checkSelfPermission(it.applicationContext, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
                // get permission
                requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),1)

            }
            else{
                val galeriIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(galeriIntent,2)

            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == 1){
            if(grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                val galeriIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(galeriIntent,2)
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if(requestCode == 2 && resultCode == Activity.RESULT_OK && data != null){
            secilenGorsel = data.data

            try {
                context?.let {
                    if(secilenGorsel != null) {
                        if(Build.VERSION.SDK_INT >= 28){
                            val source = ImageDecoder.createSource(it.contentResolver, secilenGorsel!!)
                            secilenGorselBitmap = ImageDecoder.decodeBitmap(source)
                            imageView.setImageBitmap(secilenGorselBitmap)
                        }
                        else{
                            secilenGorselBitmap = MediaStore.Images.Media.getBitmap(it.contentResolver, secilenGorsel)
                            imageView.setImageBitmap(secilenGorselBitmap)
                        }
                    }
                }

            }catch (e:Exception){
                e.printStackTrace()
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    fun kucukBitmapOlusutur(userBitmap : Bitmap, maximumBoy:Int) :Bitmap{

        var width = userBitmap.width
        var height = userBitmap.height

        val bitMapOrani : Double = width.toDouble() / height.toDouble()

        if (bitMapOrani > 1){
            // yatay
            width = maximumBoy
            val kisHeight = width / bitMapOrani
            height = kisHeight.toInt()
        }
        else{
            // dikey
            height = maximumBoy
            val kiswidth = height * bitMapOrani
            width =  kiswidth.toInt()

        }

        return Bitmap.createScaledBitmap(userBitmap,width,height,true)
    }

}