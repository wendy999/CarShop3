package com.example.carshop3.ui.vehiculosDisponibles

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.carshop3.R
import com.squareup.picasso.Picasso

class HomeViewHolder(view:View):RecyclerView.ViewHolder(view) {

    var itemImage: ImageView = itemView.findViewById(R.id.item_image)
    var itemMarca: TextView = itemView.findViewById(R.id.item_title)
    var itemDetail: TextView = itemView.findViewById(R.id.item_detail)

    fun bind(image:String){
        Picasso.get().load(image).into(itemImage)
    }

}