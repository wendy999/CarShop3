package com.example.carshop3.ui.vehiculosDisponibles.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carshop3.R
import com.example.carshop3.databinding.FragmentHomeBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.example.carshop3.data.model.VehiculoModel
import com.example.carshop3.databinding.ItemVehiculoBinding
import com.example.carshop3.ui.detalleVehiculos.view.DetailFragment
import com.example.carshop3.ui.PrincipalActivity
import com.example.carshop3.ui.vehiculosDisponibles.viewmodel.HomeViewModel
import com.squareup.picasso.Picasso


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    private lateinit var adapter: VehiculoAdapter
    private val vehiculo = mutableListOf<VehiculoModel>()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private var _bindigPrincipal: PrincipalActivity? =null
    private val bindigPrincipal get() = _bindigPrincipal

    private var _bindingItem: ItemVehiculoBinding? = null
    private val bindingItem get() = _bindingItem!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        _bindingItem = ItemVehiculoBinding.inflate(inflater,container,false)
        val root: View = binding.root
        println(vehiculo)
        initRecyclerView(root)
        prueba()
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initRecyclerView(view: View) {
        adapter = VehiculoAdapter(vehiculo,homeViewModel.imagenButton)
        binding.rvVehiculo.layoutManager = LinearLayoutManager(this.context)
        binding.rvVehiculo.adapter = adapter
        detalleVehiculo2(view)
    }

    /*fun mostrarDatos() {
        CoroutineScope(Dispatchers.IO).launch {
            var resultVeihculo = ObtenerVehiculo.vehiculo
            activity?.runOnUiThread{
                vehiculo.addAll(resultVeihculo)
                adapter.notifyDataSetChanged()
            }
        }
    }*/

    fun prueba() {
        homeViewModel.adapter.value = adapter
        CoroutineScope(Dispatchers.IO).launch {
            activity?.runOnUiThread{
                homeViewModel.adapter.observe(viewLifecycleOwner, Observer {
                    vehiculo.addAll(homeViewModel.vehiculo)
                    adapter.notifyDataSetChanged()
                })
            }
        }
    }

    fun detalleVehiculo2(view: View){
        homeViewModel.imagenButton.observe(viewLifecycleOwner,Observer{
            var args = Bundle()
            args.putString("url_image",it.imagen)
            args.putString("marca", it.marca)
            args.putString("modelo", it.modelo)
            args.putString("coleccion", it.coleccion)
            args.putString("combustion", it.combustion)
            args.putString("estado",it.estatus)
            args.putBoolean("favorito", it.favorito)

            val newFragment = DetailFragment()
            newFragment.setArguments(args);
            val transaction = childFragmentManager.beginTransaction()
            transaction.replace(R.id.content_home, newFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        })
    }

    fun obtenerDatosView1(view: View){
        val imageView: ImageView = bindingItem.itemImage
        var imagen:String

        for (item in vehiculo){
            imagen = item.imagen
            println("Imageeeeeeeen ${imagen}")
        }
        homeViewModel.itemImage.observe(viewLifecycleOwner, Observer {
            //imageView = it
            Picasso.get().load(it).into(imageView)
            println("Imageeeeeeeen ${it}")
        })
    }
}

