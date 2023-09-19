package com.example.paycard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.paycard.databinding.ActivityVerificationBinding

class Verification : AppCompatActivity() {
    lateinit var binding: ActivityVerificationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerificationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        FocusJuan()
        var name = intent.getStringExtra("name")
        var monto = intent.getStringExtra("monto")
        binding.txtName.text = "$name!!"

        binding.btnBack.setOnClickListener {
            finish()
        }

        binding.txtNewcode.setOnClickListener {
            startActivity(Intent(this@Verification, GenerationCode::class.java))
        }

        binding.btnNext.setOnClickListener {
            Validacion()

        }
    }

    fun Validacion() {
        binding.apply {
            var t1 = txtNum1.text.toString()
            var t2 = txtNum2.text.toString()
            var t3 = txtNum3.text.toString()
            var t4 = txtNum4.text.toString()
            var t5 = txtNum5.text.toString()


            var name = intent.getStringExtra("name")
            var monto = intent.getStringExtra("monto")
            Log.e(
                "a",
                GenerationCode.numAleatorio1 + GenerationCode.numAleatorio2 + GenerationCode.numAleatorio3 + GenerationCode.numAleatorio4 + GenerationCode.numAleatorio5
            )
            if (t1 == GenerationCode.numAleatorio1 && t2 == GenerationCode.numAleatorio2 && t3 == GenerationCode.numAleatorio3 && t4 == GenerationCode.numAleatorio4 && t5 == GenerationCode.numAleatorio5) {
                startActivity(
                    Intent(this@Verification, Home::class.java).putExtra("name", name)
                        .putExtra("monto", monto)
                )
            } else if (t1.isEmpty() || t2.isEmpty() || t3.isEmpty() || t4.isEmpty() || t5.isEmpty()) {
                Toast.makeText(this@Verification, "Faltan campos por llenar", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(this@Verification, "Codigo Erroneo", Toast.LENGTH_SHORT).show()
            }

        }
    }

    fun FocusJuan() {
        binding.apply {
            var txts = mutableListOf<EditText?>(txtNum1, txtNum2, txtNum3, txtNum4, txtNum5)
            txts[0]!!.requestFocus()
            txts.forEach {
                var txt: EditText = it!!
                it!!.addTextChangedListener {

                    var index = txts.indexOf(txt)

                    if (txt.text.toString().isNotEmpty()) {
                        index++
                        if (index < txts.size) {
                            txts[index]!!.requestFocus()
                        }

                    } else if (txt.text.toString().isEmpty()) {
                        index--
                        if (index >= 0) {
                            txts[index]!!.requestFocus()
                        }
                    }
                }
            }
        }

    }

    fun FocusNext() {
        binding.apply {
            txtNum1.requestFocus()
            txtNum1.addTextChangedListener {
                if (txtNum1.text.toString().isNotEmpty()) {
                    txtNum2.requestFocus()
                }
            }
            txtNum2.addTextChangedListener {
                if (txtNum2.text.toString().isNotEmpty()) {
                    txtNum3.requestFocus()
                }
            }
            txtNum3.addTextChangedListener {
                if (txtNum3.text.toString().isNotEmpty()) {
                    txtNum4.requestFocus()
                }
            }
            txtNum4.addTextChangedListener {
                if (txtNum4.text.toString().isNotEmpty()) {
                    txtNum5.requestFocus()
                }
            }
        }
    }

    fun FocusBack() {
        binding.apply {
            txtNum5.addTextChangedListener {
                if (txtNum5.text.toString().isEmpty()) {
                    txtNum4.requestFocus()
                }
            }
            txtNum4.addTextChangedListener {
                if (txtNum4.text.toString().isEmpty()) {
                    txtNum3.requestFocus()
                }
            }
            txtNum3.addTextChangedListener {
                if (txtNum3.text.toString().isEmpty()) {
                    txtNum2.requestFocus()
                }
            }
            txtNum2.addTextChangedListener {
                if (txtNum2.text.toString().isEmpty()) {
                    txtNum1.requestFocus()
                }
            }
        }
    }

}