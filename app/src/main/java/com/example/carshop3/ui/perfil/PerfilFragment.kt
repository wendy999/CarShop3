package com.example.carshop3.ui.perfil

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.Nullable
import com.afollestad.materialdialogs.MaterialDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.carshop3.BuildConfig
import com.example.carshop3.R
import com.example.carshop3.databinding.FragmentPerfilBinding
import com.example.carshop3.ui.PrincipalActivity
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import kotlin.system.exitProcess

class PerfilFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel
    private var _binding: FragmentPerfilBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var mDrawerCallback : DrawerCallback

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentPerfilBinding.inflate(inflater, container, false)
        val root: View = binding.root

        fotoPerfilPicsum()
        cerrarSesion()
        return root
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        this.mDrawerCallback = activity as (PrincipalActivity)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun fotoPerfilPicsum(){
        val foto_perfil: CircleImageView = binding.imagenPerfil
        Picasso
            .get()
            .load(BuildConfig.FOTO_PERFIL)
            .fit()
            .into(foto_perfil)
    }


    fun cerrarSesion(){
        binding.btnCerrarSesion.setOnClickListener{ 
            if (isAdded && activity != null) {
                activity?.runOnUiThread {
                    val dialog = MaterialDialog.Builder(requireActivity())
                        .customView(R.layout.cerrar_sesion, true)
                        .build()

                    val view = dialog.customView!!

                    view.findViewById<View>(R.id.CSL_textview_accept).setOnClickListener {
                        dialog.dismiss()
                        mDrawerCallback.logout()
                    }

                    view.findViewById<View>(R.id.CSL_textview_cancel).setOnClickListener { dialog.dismiss() }

                    dialog.show()
                }
            }
        }
        
    }
}

public interface DrawerCallback {
    fun logout():Unit
}