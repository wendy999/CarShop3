package com.example.carshop3.ui.vehiculosDisponibles.view

import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.carshop3.R
import com.example.carshop3.databinding.FragmentDetail2Binding
import com.example.carshop3.databinding.ItemVehiculoBinding
import com.example.carshop3.ui.vehiculosDisponibles.viewmodel.HomeViewModel
import com.squareup.picasso.Picasso

class HomeViewHolder(view:View):RecyclerView.ViewHolder(view) {

    private var _binding: ItemVehiculoBinding? = null
    val binding get() = _binding!!

    var itemImage: ImageView = itemView.findViewById(R.id.item_image)
    var itemMarca: TextView = itemView.findViewById(R.id.item_title)
    var itemDetail: TextView = itemView.findViewById(R.id.item_detail)
    var btnDetail: ImageButton = itemView.findViewById(R.id.btn_ver_detalle)

    fun bind(image:String){
        Picasso.get().load(image).into(itemImage)
    }
}