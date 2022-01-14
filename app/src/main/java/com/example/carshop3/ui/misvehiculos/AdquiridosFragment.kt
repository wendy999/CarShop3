package com.example.carshop3.ui.misvehiculos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carshop3.R
import com.example.carshop3.data.model.VehiculoModel
import com.example.carshop3.databinding.FragmentAdquiridosBinding
import com.example.carshop3.ui.detalleVehiculos.view.DetailFragment
import com.example.carshop3.ui.vehiculosDisponibles.view.VehiculoAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AdquiridosFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private var _binding: FragmentAdquiridosBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: VehiculoAdapter
    private val vehiculo = mutableListOf<VehiculoModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentAdquiridosBinding.inflate(inflater, container, false)
        val root: View = binding.root
        initRecyclerView(root)
        prueba()
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initRecyclerView(view: View) {
        adapter = VehiculoAdapter(vehiculo,dashboardViewModel.listButton)
        binding.rvVehiculo.layoutManager = LinearLayoutManager(this.context)
        binding.rvVehiculo.adapter = adapter
        detalleVehiculo2(view)
    }

    fun prueba() {
        dashboardViewModel.adapter.value = adapter
        CoroutineScope(Dispatchers.IO).launch {
            activity?.runOnUiThread{
                dashboardViewModel.adapter.observe(viewLifecycleOwner, Observer {
                    vehiculo.addAll(dashboardViewModel.vehiculo)
                    adapter.notifyDataSetChanged()
                })
            }
        }
    }

    fun detalleVehiculo2(view: View){
        dashboardViewModel.imagenButton.observe(viewLifecycleOwner,Observer{
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
            transaction.replace(R.id.content_adquiridos, newFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        })
    }


}
