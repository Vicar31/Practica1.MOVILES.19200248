package com.example.practica1moviles19200248

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class ConsumoAguaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consumo_agua)

        // Referencias a los elementos del XML
        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etPeso = findViewById<EditText>(R.id.etPeso)
        val rgGenero = findViewById<RadioGroup>(R.id.rgGenero)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        val btnVolver = findViewById<Button>(R.id.btnVolver)

        btnCalcular.setOnClickListener {
            val nombre = etNombre.text.toString().trim()
            val pesoStr = etPeso.text.toString().trim()
            val generoId = rgGenero.checkedRadioButtonId

            // Validaciones
            if (nombre.isEmpty() || pesoStr.isEmpty() || generoId == -1) {
                Snackbar.make(it, "Todos los campos son obligatorios", Snackbar.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val peso = pesoStr.toDoubleOrNull()
            if (peso == null || peso < 5 || peso > 200) {
                Snackbar.make(it, "El peso debe ser un número entre 5 y 200 kg", Snackbar.LENGTH_LONG).show()
                return@setOnClickListener
            }

            // Determinar el factor según género
            val factor = when (generoId) {
                R.id.rbMasculino -> 1.02
                R.id.rbFemenino -> 1.01
                else -> 1.00
            }

            // Cálculo
            val litros = peso * 0.035 * factor
            val resultado = String.format("%.2f", litros)

            tvResultado.text = "$nombre debe beber aproximadamente $resultado litros de agua al día"
        }

        // Botón volver
        btnVolver.setOnClickListener {
            finish()
        }
    }
}
