package com.example.paycard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.paycard.databinding.ActivityGenerationCodeBinding
import java.util.Random

class GenerationCode : AppCompatActivity() {
    lateinit var binding: ActivityGenerationCodeBinding
    lateinit var timer: CountDownTimer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGenerationCodeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnNext.setOnClickListener {
            startActivity(Intent(this@GenerationCode, Identification::class.java))
            timer.cancel()
        }
        var contador = 10
        timer = object : CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.txtContador.text = "$contador S"
                contador--
            }

            override fun onFinish() {
                contador = 10
                Aleatorio()
                Regresiva()
            }
        }
        Regresiva()
    }

    override fun onRestart() {
        super.onRestart()
        Regresiva()

    }

    private fun Regresiva() {
        timer.start()
    }


    private fun Aleatorio() {
        numAleatorio1 = Random().nextInt(9).toString()
        numAleatorio2 = Random().nextInt(9).toString()
        numAleatorio3 = Random().nextInt(9).toString()
        numAleatorio4 = Random().nextInt(9).toString()
        numAleatorio5 = Random().nextInt(9).toString()
        binding.apply {
            txtNum1.text = numAleatorio1
            txtNum2.text = numAleatorio2
            txtNum3.text = numAleatorio3
            txtNum4.text = numAleatorio4
            txtNum5.text = numAleatorio5
        }

    }

    companion object {

        var numAleatorio1 = Random().nextInt(9).toString()
        var numAleatorio2 = Random().nextInt(9).toString()
        var numAleatorio3 = Random().nextInt(9).toString()
        var numAleatorio4 = Random().nextInt(9).toString()
        var numAleatorio5 = Random().nextInt(9).toString()
    }
}