package com.amrabdelhamiddiab.pharmacy_1.presentation.Items

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amrabdelhamiddiab.pharmacy_1.presentation.activity.MainActivity.Companion.TAG
import com.amrabdelhamiddiab.pharmacy_1.R
import com.amrabdelhamiddiab.pharmacy_1.databinding.FragmentMedicinesBinding
import com.amrabdelhamiddiab.pharmacy_1.framework.utilis.PharmacyViewModelFactory
import com.amrabdelhamiddiab.pharmacy_1.presentation.home.HomeViewModel

class ItemsFragment : Fragment() {
    private lateinit var binding: FragmentMedicinesBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var gridLayoutManager: GridLayoutManager

/*    private val viewModel: MedicinesViewModel by lazy {
        ViewModelProvider(this, PharmacyViewModelFactory)[MedicinesViewModel::class.java]
    }*/
    private val viewModel: HomeViewModel by navGraphViewModels(R.id.nested_graph_home){
        PharmacyViewModelFactory
}
    private val medicineEpoxyController by lazy {
        ItemsEpoxyController(viewModel)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_medicines, container, false)
        recyclerView = binding.recyclerViewMedicines
        gridLayoutManager = GridLayoutManager(context, 2)
        recyclerView.layoutManager = gridLayoutManager
        recyclerView.adapter = medicineEpoxyController.adapter
        viewModel.downloading.observe(viewLifecycleOwner) {
            if (it) {
                binding.loadingIndecatorMedicines.visibility = View.VISIBLE
            } else {
                binding.loadingIndecatorMedicines.visibility = View.GONE
            }
        }
        viewModel.listOfMedicines.observe(viewLifecycleOwner){
            //  Log.d(TAG, "AAAAA"+ a.toString() +"BBBBB"+ b.toString())
            medicineEpoxyController.setData(it)
        }
    /*    viewModel.urlSubCategory.observe(viewLifecycleOwner){
            viewModel.downloadMedicines("medicine/$it")
        }*/
        //   viewModel.downloadImagesOfSlider()
        //  viewModel.downloadOffers()
        viewModel.downloadMedicines("${viewModel.urlSubCategory.value}")
        Log.d(TAG,"*8*8*8*8*8*8${viewModel.urlSubCategory.value}" )
        return binding.root
    }
}