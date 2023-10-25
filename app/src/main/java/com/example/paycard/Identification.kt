package com.example.paycard

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.paycard.Userpreference.Companion.prefs
import com.example.paycard.databinding.ActivityIdentificationBinding

class Identification : AppCompatActivity() {
    lateinit var binding: ActivityIdentificationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIdentificationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnBack.setOnClickListener {
            finish()
        }

        binding.btnNext.setOnClickListener {
            if (binding.txtName.text.toString().isNotEmpty() || binding.txtMonto.text.toString()
                    .isNotEmpty()
            ) {
                EnviarDatos()
            } else {
                Toast.makeText(this, "Faltan camnpos por llenar", Toast.LENGTH_SHORT).show()
            }
        }


    }

    private fun EnviarDatos() {
        var nameFull = binding.txtName.text.toString()
        var name = nameFull.split(" ").first()

        var monto = binding.txtMonto.text.toString()
        startActivity(
            Intent(this@Identification, Verification::class.java)
                .putExtra("name", name)
                .putExtra("monto", monto)
        )
        prefs.GuardarName(name)
        prefs.GuaradarMonto(monto)
    }


}