package com.amrabdelhamiddiab.pharmacy_1.presentation.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amrabdelhamiddiab.core.data.IPreferenceHelper
import com.amrabdelhamiddiab.core.domain.ImageOfSlider
import com.amrabdelhamiddiab.pharmacy_1.presentation.activity.MainActivity.Companion.TAG
import com.amrabdelhamiddiab.pharmacy_1.R
import com.amrabdelhamiddiab.pharmacy_1.databinding.FragmentHomeBinding
import com.amrabdelhamiddiab.pharmacy_1.framework.utilis.PharmacyViewModelFactory
import com.amrabdelhamiddiab.pharmacy_1.framework.utilis.PreferenceManager

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var preferenceHelper: IPreferenceHelper

    //Note epoxy recycler view doesn't update the inner
    // recycler views,so i used normal recycler view
    private lateinit var recyclerView: RecyclerView
    private lateinit var layoutManager: LinearLayoutManager
    private val homeEpoxyController by lazy {
        HomeEpoxyController(viewModel)
    }
    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this, PharmacyViewModelFactory)[HomeViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        preferenceHelper = PreferenceManager(requireActivity().applicationContext)
        if (!preferenceHelper.getUserLoggedIn()) {
            findNavController().navigate(R.id.action_global_nested_graph_login)
        }
        recyclerView = binding.recyclerViewHome
        recyclerView.adapter = homeEpoxyController.adapter
        layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager
        viewModel.downloading.observe(viewLifecycleOwner) {
            if (it) {
                binding.loadingIndecatorHome.visibility = View.VISIBLE
            } else {
                binding.loadingIndecatorHome.visibility = View.GONE
            }
        }
        viewModel.mainCategory.observe(viewLifecycleOwner) {
            val directions =
                HomeFragmentDirections.actionHomeFragmentToMedicineSubCategoriesFragment2(it)
            findNavController().navigate(directions)
        }
        viewModel.listOfHomeScreenItems.observe(viewLifecycleOwner) {
            homeEpoxyController.setData(it)
        }
        viewModel.downloadHomeScreenItems()
        return binding.root
    }
}