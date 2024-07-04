package com.desafiolatam.desafio3


import android.os.Bundle
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Sucursal(
    val nombre: String,
    val direccion: String,
    val horario: String,
    val foto: String,
    val historia: String
) : Parcelable {
    companion object {
        fun fromBundle(bundle: Bundle): Sucursal {
            return Sucursal(
                bundle.getString("nombre") ?: "",
                bundle.getString("direccion") ?: "",
                bundle.getString("horario") ?: "",
                bundle.getString("foto") ?: "",
                bundle.getString("historia") ?: ""
            )
        }
    }

    fun toBundle(): Bundle {
        return Bundle().apply {
            putString("nombre", nombre)
            putString("direccion", direccion)
            putString("horario", horario)
            putString("foto", foto)
            putString("historia", historia)
        }
    }
}
