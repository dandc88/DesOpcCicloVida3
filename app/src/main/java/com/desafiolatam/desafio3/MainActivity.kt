package com.desafiolatam.desafio3


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.desafiolatam.desafio3.databinding.ActivityMainBinding
import com.desafiolatam.desafio6m5.data.StoreRepository

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //Lista de sucursales
        val storeRepository = StoreRepository()
        val sucursales = storeRepository.getSucursales()


        // Configurar RecyclerView
        val recyclerView: RecyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = SucursalAdapter(this, sucursales)



    }




}