package com.amrabdelhamiddiab.pharmacy_1.presentation.medicineSubCategories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amrabdelhamiddiab.core.domain.dataSources.ListOfSubCategoriesItems
import com.amrabdelhamiddiab.pharmacy_1.R
import com.amrabdelhamiddiab.pharmacy_1.databinding.FragmentMedicineSubCategoriesBinding

class MedicineSubCategoriesFragment : Fragment() {
    private lateinit var binding: FragmentMedicineSubCategoriesBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var gridLayoutManager: GridLayoutManager
    private val medicineSubCategoriesEpoxyController by lazy {
        MedicineSubCategoriesEpoxyController()
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
        medicineSubCategoriesEpoxyController.setData(ListOfSubCategoriesItems().listOfSubCategories)
        return binding.root
    }

}