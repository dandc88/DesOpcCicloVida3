package com.desafiolatam.desafio3

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.desafiolatam.desafio3.databinding.ItemSucursalBinding

class SucursalAdapter(
    private val context: Context,
    private val sucursales: List<Sucursal>
) : RecyclerView.Adapter<SucursalAdapter.SucursalViewHolder>() {

    inner class SucursalViewHolder(private val binding: ItemSucursalBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(sucursal: Sucursal) {
            binding.nombreSucursalTextView.text = sucursal.nombre
            binding.horarioSucursalTextView.text = sucursal.horario


            //Se utiliza Glide para cargar la foto de internet a la app
            Glide.with(context)
                .load(sucursal.foto)
                .into(binding.sucursalImageView)


            binding.root.setOnClickListener {
                val intent = Intent(context, DetallesSucursalActivity::class.java)
                intent.putExtra("sucursalBundle", sucursal.toBundle())
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SucursalViewHolder {
        val binding = ItemSucursalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SucursalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SucursalViewHolder, position: Int) {
        holder.bind(sucursales[position])
    }

    override fun getItemCount(): Int = sucursales.size
}