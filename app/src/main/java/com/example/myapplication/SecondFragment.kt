package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentSecondBinding
import com.google.android.material.navigation.NavigationView

class SecondFragment : Fragment() {
    private var _binding:FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Codigo

        val drawerLayout: DrawerLayout = binding.secondFragment
        val navView: NavigationView = binding.navView

        val toggle = ActionBarDrawerToggle(
            requireActivity(),
            drawerLayout,
            requireActivity().findViewById(R.id.toolbar), // Cambia esta línea
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        val navController = findNavController()
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_add -> {

                    navController.navigate(R.id.otherFragment)
                    true
                }
                R.id.nav_see -> {
                    val fragmentB = Other2Fragment()
                    val transaction = childFragmentManager.beginTransaction()
                    childFragmentManager.popBackStackImmediate() // Limpiar la pila de retroceso
                    transaction.replace(R.id.secondFragment, fragmentB)
                    transaction.addToBackStack(null)
                    transaction.commit()
                    true
                }
                R.id.nav_edit -> {
                    // Lógica para la opción Editar
                    true
                }
                else -> false
            }
        }

    }

}