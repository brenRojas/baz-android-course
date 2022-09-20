package com.brendarojas.criptomonedaswizeline

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.brendarojas.criptomonedaswizeline.webservice.CryptoDao

class MainActivity : AppCompatActivity() {

    var availableBooksDao = CryptoDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        availableBooksDao.consumirServicioGet()
    }



}