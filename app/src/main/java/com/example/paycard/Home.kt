package com.example.paycard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.paycard.databinding.ActivityHomeBinding

class Home : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var name = intent.getStringExtra("name")
        var monto = intent.getStringExtra("monto")
        binding.txtName.text = name
        binding.txtMonto.text = monto
    }




}