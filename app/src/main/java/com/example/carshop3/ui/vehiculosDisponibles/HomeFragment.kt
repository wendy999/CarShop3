package com.example.carshop3.ui.vehiculosDisponibles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carshop3.core.RetrofitHelper.getRetrofit
import com.example.carshop3.data.network.APIService
import com.example.carshop3.databinding.FragmentHomeBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.example.carshop3.data.model.VehiculoModel
import com.example.carshop3.databinding.ItemVehiculoBinding

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var adapter: VehiculoAdapter
    private val vehiculo = mutableListOf<VehiculoModel>()

    private var _binding: FragmentHomeBinding? = null
    private  var _bindingDetail:ItemVehiculoBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val bindingDetail get() = _bindingDetail!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        initRecyclerView()
        mostrarDatos()
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    //se llama el Recicler view
    private fun initRecyclerView() {
        adapter = VehiculoAdapter(vehiculo)
        binding.rvVehiculo.layoutManager = LinearLayoutManager(this.context)
        binding.rvVehiculo.adapter = adapter
    }

    fun mostrarDatos() {
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIService::class.java).getVehiculos("d8c1c023-5ab7-413c-bbec-a3963ff3eed7")
            val vehiculoRet= call.body()

            activity?.runOnUiThread{
                if (call.isSuccessful) {
                    val lisVehiculos:List<VehiculoModel> = vehiculoRet?.vehiculo ?: emptyList()
                    vehiculo.addAll(lisVehiculos)
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }
}
