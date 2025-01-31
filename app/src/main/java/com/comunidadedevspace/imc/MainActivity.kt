package com.comunidadedevspace.imc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    


        val edtWeight = findViewById<TextInputEditText>(R.id.edit_weight)
        val edtHeight = findViewById<TextInputEditText>(R.id.edit_height)

        val btnCalculate = findViewById<Button>(R.id.btn_calcular)


       btnCalculate.setOnClickListener{


           val weightStr: String = edtWeight.text.toString()
           val heightStr: String = edtHeight.text.toString()

           if (weightStr == "" || heightStr == ""){

               Snackbar.make(
                   edtHeight,
                   "Complete all fields",
                   Snackbar.LENGTH_LONG
               )
                   .show()

           } else {

               val height = heightStr.toFloat()
               val weight = weightStr.toFloat()

               val heightQ2 = height * height
               val result = weight / heightQ2

               val intent = Intent(this, ResultActivity::class.java)
               intent.putExtra("KEY_RESULT_IMC", result)
               startActivity(intent)








           }


       }

    }
}

