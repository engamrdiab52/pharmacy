package com.amrabdelhamiddiab.pharmacy_1.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.amrabdelhamiddiab.core.data.IPreferenceHelper
import com.amrabdelhamiddiab.pharmacy_1.R
import com.amrabdelhamiddiab.pharmacy_1.databinding.FragmentHomeBinding
import com.amrabdelhamiddiab.pharmacy_1.framework.utilis.PreferenceManager

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var preferenceHelper: IPreferenceHelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        preferenceHelper = PreferenceManager(requireActivity().applicationContext)
        if (!preferenceHelper.getUserLoggedIn()) {
            findNavController().navigate(R.id.action_global_nested_graph_login)
        }
        // Inflate the layout for this fragment
        return binding.root
    }

}