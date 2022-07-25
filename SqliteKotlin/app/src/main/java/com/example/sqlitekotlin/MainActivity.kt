package com.example.sqlitekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // try catch

        try{
            val veritabani = this.openOrCreateDatabase("Urunler", MODE_PRIVATE, null)

            veritabani.execSQL("CREATE TABLE IF NOT EXISTS urunler (id INTEGER PRIMARY KEY, isim VARCHAR, fiyat INT)")
            //veritabani.execSQL("INSERT INTO urunler (isim, fiyat) VALUES ('Ayakkabi', 100)")
            //veritabani.execSQL("INSERT INTO urunler (isim, fiyat) VALUES ('elbise', 150)")
            //veritabani.execSQL("INSERT INTO urunler (isim, fiyat) VALUES ('bere', 59)")
            //veritabani.execSQL("INSERT INTO urunler (isim, fiyat) VALUES ('tshirt', 200)")
            //veritabani.execSQL("INSERT INTO urunler (isim, fiyat) VALUES ('atki', 10)")

            //veritabani.execSQL("DELETE FROM urunler WHERE id=5")
            //veritabani.execSQL("UPDATE urunler SET fiyat = 250 WHERE isim='elbise'")
            //veritabani.execSQL("UPDATE urunler SET id = 5 WHERE id=6")
            val cursor = veritabani.rawQuery("SELECT * FROM urunler", null)
            //val cursor = veritabani.rawQuery("SELECT * FROM urunler WHERE isim = 'bere'", null)
            //val cursor = veritabani.rawQuery("SELECT * FROM urunler WHERE id = 4", null)
            // a ile baslayanlar
            //val cursor = veritabani.rawQuery("SELECT * FROM urunler WHERE isim LIKE 'a%'", null)
            // i ile bitenlerr
            //val cursor = veritabani.rawQuery("SELECT * FROM urunler WHERE isim LIKE '%i'", null)



            val idColumnIndex = cursor.getColumnIndex("id")
            val isimColumnIndex = cursor.getColumnIndex("isim")
            val fiyatColumnIndex = cursor.getColumnIndex("fiyat")

            while (cursor.moveToNext()){
                println("ID : ${cursor.getInt(idColumnIndex)}")
                println("ID : ${cursor.getString(isimColumnIndex)}")
                println("ID : ${cursor.getInt(fiyatColumnIndex)}")
            }

            cursor.close()

        }catch (e: Exception){
            e.printStackTrace()
        }
    }
}