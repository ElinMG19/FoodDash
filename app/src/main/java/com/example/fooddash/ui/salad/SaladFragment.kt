package com.example.fooddash.ui.salad

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.fooddash.databinding.FragmentSaladsBinding
import com.example.fooddash.ui.CustomAdapterProducts

class SaladFragment : Fragment() {

    private var _binding: FragmentSaladsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var saladViewModel: SaladViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        saladViewModel =
            ViewModelProvider(this)[SaladViewModel::class.java]

        _binding = FragmentSaladsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        saladViewModel.listProducts.observe(viewLifecycleOwner) {
            val adapter = CustomAdapterProducts(requireActivity(), it)
            binding.containerSalads.setHasFixedSize(true)
            binding.containerSalads.adapter = adapter
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}