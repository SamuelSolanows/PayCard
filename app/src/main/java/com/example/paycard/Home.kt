package com.example.paycard

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.paycard.Userpreference.Companion.prefs
import com.example.paycard.databinding.ActivityHomeBinding

class Home : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding

    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //var name = intent.getStringExtra("name")
        //var monto = intent.getStringExtra("monto")
        binding.txtName.text = prefs.GetName()
        binding.txtMonto.text = prefs.GetMonto()
        prefs.GuardarSeccion(true)

        binding.Cerrar.setOnClickListener {
            prefs.GuardarSeccion(false)
            prefs.GuaradarMonto("")
            prefs.GuardarName("")
            startActivity(Intent(this, About::class.java))
        }
    }


}