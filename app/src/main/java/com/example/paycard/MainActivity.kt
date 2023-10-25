package com.example.paycard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.paycard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        CuentaRegresiva()

    }
    var prefe = ".."
    private fun CuentaRegresiva() {
        var contador = 3
        object : CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.txtCuentaregresiva.text = contador.toString() + "s"
                contador -= 1
            }

            override fun onFinish() {
                if (prefe.isNotEmpty()) {
                    startActivity(Intent(this@MainActivity, Home::class.java))
                } else {
                    startActivity(Intent(this@MainActivity, About::class.java))

                }
                finish()
            }
        }.start()
    }


}

