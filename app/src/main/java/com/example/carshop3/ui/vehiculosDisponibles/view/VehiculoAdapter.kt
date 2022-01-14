package com.example.carshop3.ui.vehiculosDisponibles.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.carshop3.R
import com.example.carshop3.data.model.VehiculoModel

class VehiculoAdapter(val vehiculo:List<VehiculoModel>, val imagenButton: MutableLiveData<VehiculoModel>):RecyclerView.Adapter<HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.item_vehiculo,parent,false)
        return HomeViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val item = vehiculo[position]
        holder.itemDetail.text =  item.modelo
        holder.bind(item.imagen)
        holder.itemMarca.text =  item.marca

        holder.btnDetail.setOnClickListener{
                imagenButton.value = item
        }
    }

    override fun getItemCount(): Int {
        return vehiculo.size
    }

}