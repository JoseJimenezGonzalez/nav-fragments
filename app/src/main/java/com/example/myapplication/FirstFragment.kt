package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    //onCreateView()
    //El sistema lo llama cuando el fragmento debe diseñar su interfaz de usuario por primera vez.
    // A fin de diseñar una IU para tu fragmento, debes mostrar un View desde este método, que será
    // la raíz del diseño de tu fragmento. Puedes mostrar un valor nulo si el fragmento no proporciona una IU.

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }
    //onViewCreated()
    //Called immediately after #onCreateView(LayoutInflater, ViewGroup, Bundle) has returned, but
    // before any saved state has been restored in to the view.

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnTercerFragment.setOnClickListener{
            findNavController().navigate(R.id.action_firstFragment_to_thirdFragment)
        }
        binding.btnCuartoFragment.setOnClickListener{
            findNavController().navigate(R.id.action_firstFragment_to_fourthFragment)
        }
    }

}