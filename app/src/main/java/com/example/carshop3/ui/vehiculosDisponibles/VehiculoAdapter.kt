package com.example.carshop3.ui.vehiculosDisponibles

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carshop3.R
import com.example.carshop3.data.model.VehiclesList
import com.example.carshop3.data.model.VehiculoModel

class VehiculoAdapter(val vehiculo:List<VehiculoModel>): RecyclerView.Adapter<HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.item_vehiculo,parent,false)
        return HomeViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val item = vehiculo[position]
        holder.itemDetail.text =  item.modelo.toString()
        holder.bind(item.imagen)
        holder.itemMarca.text = item.marca
    }

    override fun getItemCount(): Int {
        return vehiculo.size
    }
}