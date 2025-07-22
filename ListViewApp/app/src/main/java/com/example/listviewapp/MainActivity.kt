package com.example.listviewapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.listviewapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //____________________________________________________________________________________________________
        val listaNomes = ArrayList<String>()

        listaNomes.add("Vitor")
        listaNomes.add("Joaquim")
        listaNomes.add("Joana")
        listaNomes.add("António")

        var arrayAdapterNomes = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaNomes)

        binding.listView.adapter = arrayAdapterNomes

        //____________________________________________________________________________________________________


        val arrayListUtilizadores = ArrayList<Utilizador>()

        arrayListUtilizadores.add(Utilizador("admin", "12345"))
        arrayListUtilizadores.add(Utilizador("staff", "pass"))
        arrayListUtilizadores.add(Utilizador("vitor", "123"))

        var arrayAdapterUtilizadores =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayListUtilizadores)
        binding.listUtilizadores.adapter = arrayAdapterUtilizadores

        //____________________________________________________________________________________________________

        binding.buttonAdicionarNome.setOnClickListener {

            var novoNome = binding.editNovoNome.text.toString()

            if (!novoNome.isNullOrEmpty()) {
                listaNomes.add(novoNome)

                arrayAdapterNomes =
                    ArrayAdapter(this, android.R.layout.simple_list_item_1, listaNomes)

                binding.listView.adapter = arrayAdapterNomes
            }

            binding.editNovoNome.setText("")

        }


        binding.listView.setOnItemClickListener { parent, view, position, id ->

            Toast.makeText(this, "Olá ${listaNomes.get(position)}", Toast.LENGTH_SHORT).show()

        }

        //____________________________________________________________________________________________________

        binding.listUtilizadores.setOnItemClickListener { parent, view, position, id ->

            Toast.makeText(this, "password: ${arrayListUtilizadores.get(position).password}", Toast.LENGTH_SHORT).show()

        }

    }
}