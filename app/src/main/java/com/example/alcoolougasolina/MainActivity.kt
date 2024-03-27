package com.example.alcoolougasolina

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var percentual:Double = 0.7
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btCalcular: Button = findViewById(R.id.btCalcular)
        val etValorAlcool: EditText = findViewById(R.id.edAlcool)
        val etValorGasolina: EditText = findViewById(R.id.edGasolina)
        val textResultado: TextView = findViewById(R.id.textMsg)
        val switchPercentual: Switch = findViewById(R.id.swPercentual)

        switchPercentual.setOnCheckedChangeListener { _, isChecked ->
            percentual = if (isChecked) 0.75 else 0.7
        }

        btCalcular.setOnClickListener {
            val valorAlcoolStr = etValorAlcool.text.toString()
            val valorGasolinaStr = etValorGasolina.text.toString()

            if (valorAlcoolStr.isNotEmpty() && valorGasolinaStr.isNotEmpty()) {
                val valorAlcool = valorAlcoolStr.toDouble()
                val valorGasolina = valorGasolinaStr.toDouble()

                val calculo = valorAlcool / (valorGasolina * percentual)

                val mensagem = if (calculo <= 1) {
                    "Abasteça com álcool ($percentual% do valor da gasolina ou menos)"
                } else {
                    "Abasteça com gasolina"
                }

                textResultado.text = mensagem
            }
        }
    }

override fun onResume(){
    super.onResume()
    Log.d("PDM24","No onResume, $percentual")
}
override fun onStart(){
    super.onStart()
    Log.v("PDM24","No onStart")
}
override fun onPause(){
    super.onPause()
    Log.e("PDM24","No onPause")
}
override fun onStop(){
    super.onStop()
    Log.w("PDM24","No onStop")
}
override fun onDestroy(){
    super.onDestroy()
    Log.wtf("PDM24","No Destroy")
}
}