package com.example.fooddash.ui.drinks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.fooddash.databinding.FragmentDrinksBinding
import com.example.fooddash.ui.CustomAdapterProducts

class DrinkFragment : Fragment() {

    private var _binding: FragmentDrinksBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var drinkViewModel: DrinkViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        drinkViewModel =
            ViewModelProvider(this)[DrinkViewModel::class.java]

        _binding = FragmentDrinksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        drinkViewModel.listProducts.observe(viewLifecycleOwner) {
            val adapter = CustomAdapterProducts(requireActivity(), it)
            binding.containerDrinks.setHasFixedSize(true)
            binding.containerDrinks.adapter = adapter
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}