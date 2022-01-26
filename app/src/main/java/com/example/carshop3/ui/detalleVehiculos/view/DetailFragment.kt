package com.example.carshop3.ui.detalleVehiculos.view

import android.app.AlertDialog
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.carshop3.R
import com.example.carshop3.databinding.FragmentDetail2Binding
import com.example.carshop3.ui.detalleVehiculos.viewmodel.DetailViewModel
import com.example.carshop3.ui.misvehiculos.AdquiridosFragment
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso

// TODO: Rename parameter arguments, choose names that match


class DetailFragment() : Fragment() {

    private lateinit var viewModel: DetailViewModel


    private var _binding: FragmentDetail2Binding? = null
    private val binding get() = _binding!!

    //Parametros del objeto
    var imagen:String? =null
    var marca:String? = null
    var modelo:String? = null
    var coleccion:String? = null
    var combustion:String? = null
    var favorito:Boolean? = null
    var estado:String? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            imagen = it.getString("url_image")
            marca = it.getString("marca")
            modelo = it.getString("modelo")
            coleccion = it.getString("coleccion")
            combustion = it.getString("combustion")
            favorito = it.getBoolean("favorito")
            estado = it.getString("estado")
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View?{
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        _binding = FragmentDetail2Binding.inflate(inflater, container, false)
        val root: View = binding.root
        obtenerDatosView()
        return root
    }

    override fun onDestroyView(){
        super.onDestroyView()
        _binding = null
    }

    fun obtenerDatosView(){
        val detalleImage: ImageView = binding.itemImageDetail
        Picasso.get().load(imagen).into(detalleImage)

        val detalleMarca:  TextView  = binding.itemDetail
        detalleMarca.text = marca

        val detalleModelo:  TextView  = binding.itemModelo
        detalleModelo.text = modelo

        val detalleColeccion:  TextView  = binding.itemColeccion
        detalleColeccion.text = coleccion

        val detalleCombustion:  TextView  = binding.itemCombustion
        detalleCombustion.text = combustion

        viewModel.estadoDetail.value = estado
        viewModel.estadoDetail.observe(viewLifecycleOwner, Observer {
            binding.itemEstado.text = it
            if (it == "cOMpRaDO"){
                binding.btnObtener.text = "Eliminar"
                binding.btnObtener.setOnClickListener {

                }
            }
            if(it == "Desactivado"){
                binding.btnObtener.text = "Obtener"
                //binding.btnObtener.setEnabled(false)
                binding.btnObtener.setOnClickListener {
                    Toast.makeText(context, "El vehiculo esta inhabilitado", Toast.LENGTH_SHORT).show()
                }
            }
        })

        //binding.btnObtener.setBackgroundColor(Color.WHITE);
        binding.fab.setOnClickListener{
            viewModel.floatinActionButton.observe(viewLifecycleOwner,Observer{
                var args = Bundle()
                args.putString("url_image",it.imagen)
                args.putString("marca", it.marca)
                args.putString("modelo", it.modelo)
                args.putString("coleccion", it.coleccion)
                args.putString("combustion", it.combustion)
                args.putString("Estatus",it.estatus)
                args.putBoolean("favorito",it.favorito)

                val newFragment = AdquiridosFragment()
                newFragment.setArguments(args);
                val transaction = childFragmentManager.beginTransaction()
                transaction.replace(R.id.contenetdor_Detail, newFragment)
                transaction.addToBackStack(null)
                transaction.commit()
            })
        }

        viewModel.FabDetail.value = favorito
        val fab: View = binding.fab

        viewModel.FabDetail.observe(viewLifecycleOwner, Observer {

                if (it == true){ fab.setBackgroundTintList(ColorStateList.valueOf(Color.RED)) }
                else{ fab.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE)) }

            fab.setOnClickListener { view ->

                if (it == true){
                    fab.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE))
                    Toast.makeText(context, "Vehiculo eliminado de favoritos", Toast.LENGTH_SHORT).show()
                    favorito = false
                    viewModel.FabDetail.value = favorito
                }

                if (it ==false){
                    fab.setBackgroundTintList(ColorStateList.valueOf(Color.RED))
                    Toast.makeText(context, "Vehiculo añadido a favoritos", Toast.LENGTH_SHORT).show()
                    favorito = true
                    viewModel.FabDetail.value = favorito
                }
            }
        })
    }
}