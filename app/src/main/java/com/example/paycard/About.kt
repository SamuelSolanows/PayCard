package com.example.paycard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.paycard.databinding.ActivityAboutBinding
import com.example.paycard.databinding.ActivityMainBinding

class About : AppCompatActivity() {
    lateinit var binding: ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnNext.setOnClickListener {
            startActivity(Intent(this@About,GenerationCode::class.java))
            finish()
        }
    }
}