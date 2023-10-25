package com.example.paycard

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.paycard.databinding.ActivityHomeBinding

class Home : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding

    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)



        var name = intent.getStringExtra("name")
        var monto = intent.getStringExtra("monto")
        binding.txtName.text = name
        binding.txtMonto.text = monto

        var namePreference = getSharedPreferences("name", MODE_PRIVATE)
        var montoPreference = getSharedPreferences("monto", MODE_PRIVATE)

        namePreference.edit().putString("name", name)
        montoPreference.edit().putString("monto", monto)
    }


}