package com.example.saudacaoapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.saudacaoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonCumprimentar.setOnClickListener {

            var nomeInput = binding.editPrimeiroNome.text.toString()
            var apelidoInput = binding.editApelido.text.toString()

            if (nomeInput.isNullOrEmpty() || apelidoInput.isNullOrEmpty()) {
                Toast.makeText(applicationContext, "Por favor preencha ambos os campos!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext, "Olá $nomeInput $apelidoInput!", Toast.LENGTH_SHORT).show()
            }


        }

    }
}