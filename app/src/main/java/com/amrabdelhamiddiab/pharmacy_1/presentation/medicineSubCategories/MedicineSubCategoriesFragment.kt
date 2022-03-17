package com.amrabdelhamiddiab.pharmacy_1.presentation.medicineSubCategories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amrabdelhamiddiab.core.domain.dataSources.ListOfSubCategoriesItems
import com.amrabdelhamiddiab.pharmacy_1.R
import com.amrabdelhamiddiab.pharmacy_1.databinding.FragmentMedicineSubCategoriesBinding
import com.amrabdelhamiddiab.pharmacy_1.framework.utilis.PharmacyViewModelFactory
import com.amrabdelhamiddiab.pharmacy_1.presentation.medicines.MedicinesViewModel

class MedicineSubCategoriesFragment : Fragment() {
    private lateinit var binding: FragmentMedicineSubCategoriesBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var gridLayoutManager: GridLayoutManager
    private val medicineSubCategoriesEpoxyController by lazy {
        MedicineSubCategoriesEpoxyController(viewModel)
    }
    private val viewModel: MedicinesViewModel by navGraphViewModels(R.id.nested_graph_medicne_group){
        PharmacyViewModelFactory
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_medicine_sub_categories,
            container,
            false
        )
        recyclerView = binding.recyclerViewMedicineSubCategories
        gridLayoutManager = GridLayoutManager(context, 3)
        recyclerView.layoutManager = gridLayoutManager
        recyclerView.adapter = medicineSubCategoriesEpoxyController.adapter
        viewModel.subCategoryIconClicked.observe(viewLifecycleOwner){
            findNavController().navigate(R.id.action_medicineSubCategoriesFragment_to_medicinesFragment)
        }
        medicineSubCategoriesEpoxyController.setData(ListOfSubCategoriesItems().listOfSubCategories)
        return binding.root
    }

}