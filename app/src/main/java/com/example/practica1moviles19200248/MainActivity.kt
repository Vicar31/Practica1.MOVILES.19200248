package com.example.practica1moviles19200248

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.compose.setContent
import com.example.catalogoautos.PantallaCatalogoAutos

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCons = findViewById<Button>(R.id.btnCons)
        val btnAct = findViewById<Button>(R.id.btnAct)
        val btnAut = findViewById<Button>(R.id.btnAut)

        btnCons.setOnClickListener {
            val intent = Intent(this, ConsumoAguaActivity()::class.java)
            startActivity(intent)
        }

        btnAct.setOnClickListener {
            val intent = Intent(this, ActividadFisicaActivity()::class.java)
            startActivity(intent)
        }

        btnAut.setOnClickListener {
            //setContent {
                //PantallaCatalogoAutos()
            //}
        }
    }
}

