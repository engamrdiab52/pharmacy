package com.amrabdelhamiddiab.pharmacy_1.presentation.subCategories

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amrabdelhamiddiab.core.domain.dataSources.ListOfSubCategoriesItems
import com.amrabdelhamiddiab.pharmacy_1.R
import com.amrabdelhamiddiab.pharmacy_1.databinding.FragmentMedicineSubCategoriesBinding
import com.amrabdelhamiddiab.pharmacy_1.framework.utilis.PharmacyViewModelFactory
import com.amrabdelhamiddiab.pharmacy_1.presentation.home.HomeViewModel

class SubCategoriesFragment : Fragment() {
    private lateinit var binding: FragmentMedicineSubCategoriesBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var gridLayoutManager: GridLayoutManager
    private val medicineSubCategoriesEpoxyController by lazy {
        subCategoriesEpoxyController(viewModel)
    }
    private val viewModel: HomeViewModel by navGraphViewModels(R.id.nested_graph_home) {
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
        val bundle = arguments
        if (bundle == null) {
            Log.e("Confirmation", "ConfirmationFragment did not receive traveler information")
        }
        val args = SubCategoriesFragmentArgs.fromBundle(bundle!!)
        recyclerView = binding.recyclerViewMedicineSubCategories
        gridLayoutManager = GridLayoutManager(context, 3)
        recyclerView.layoutManager = gridLayoutManager
        recyclerView.adapter = medicineSubCategoriesEpoxyController.adapter
        viewModel.subCategoryIconClicked.observe(viewLifecycleOwner) {
            findNavController().navigate(R.id.action_medicineSubCategoriesFragment2_to_medicinesFragment2)
        }
        when (args.mainCategoryName) {
            "MEDICINE" -> {
                medicineSubCategoriesEpoxyController.setData(ListOfSubCategoriesItems().listOfMedicineSubCategories)
            }
            "HEALTH" -> {
                medicineSubCategoriesEpoxyController.setData(ListOfSubCategoriesItems().listOfHealthSubCategories)
            }
            "ACCESSORIES" -> {
                medicineSubCategoriesEpoxyController.setData(ListOfSubCategoriesItems().listOfAccessoriesSubCategories)
            }
            "PERSONAL CARE" -> {
                medicineSubCategoriesEpoxyController.setData(ListOfSubCategoriesItems().listOfPersonalCareSubCategories)
            }
            "BEAUTY CARE" -> {
                medicineSubCategoriesEpoxyController.setData(ListOfSubCategoriesItems().listOfBeautyCareSubCategories)
            }
            else -> {
                Toast.makeText(requireContext(), "Something wrong", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }

}