package com.example.loginapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.loginapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonLogin.setOnClickListener {

            var usernameInput = binding.editUsername.text.toString()
            var passwordInput = binding.editPassword.text.toString()

            binding.editUsername.setText("")
            binding.editPassword.setText("")

            if (usernameInput.equals("user") && passwordInput.equals("pass")) { // LOGIN VÁLIDO

                val intent = Intent(this,MenuInicialActivity::class.java)
                startActivity(intent)

            } else { // LOGIN INVÁLIDO
                Toast.makeText(applicationContext, "Credenciais inválidas", Toast.LENGTH_SHORT)
                    .show()
            }

        }

    }
}