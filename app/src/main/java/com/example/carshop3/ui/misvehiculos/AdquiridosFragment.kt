package com.example.carshop3.ui.misvehiculos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.carshop3.databinding.FragmentAdquiridosBinding

class AdquiridosFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private var _binding: FragmentAdquiridosBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentAdquiridosBinding.inflate(inflater, container, false)
        val root: View = binding.root

            return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}