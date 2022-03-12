package com.amrabdelhamiddiab.pharmacy_1.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.epoxy.EpoxyRecyclerView
import com.amrabdelhamiddiab.core.data.IPreferenceHelper
import com.amrabdelhamiddiab.core.domain.ImageOfSlider
import com.amrabdelhamiddiab.pharmacy_1.R
import com.amrabdelhamiddiab.pharmacy_1.databinding.FragmentHomeBinding
import com.amrabdelhamiddiab.pharmacy_1.framework.utilis.PreferenceManager

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var preferenceHelper: IPreferenceHelper
    private lateinit var recyclerView: EpoxyRecyclerView
    private lateinit var layoutManager: LinearLayoutManager

    /*    private val myList = listOf(
            ImageOfSlider(1000L, "gs://pharmacy-31cb6.appspot.com/slider images/image_1.png" ),
            ImageOfSlider(2000L, "gs://pharmacy-31cb6.appspot.com/slider images/image_2.png"),
            ImageOfSlider(3000L, "gs://pharmacy-31cb6.appspot.com/slider images/image_3.png"),
            ImageOfSlider(4000L,"gs://pharmacy-31cb6.appspot.com/slider images/image_4.png"),
            ImageOfSlider(5000L, "gs://pharmacy-31cb6.appspot.com/slider images/image_5.png"),
            ImageOfSlider(6000L, "gs://pharmacy-31cb6.appspot.com/slider images/image_6.png")
          )*/
    private val myList = listOf(
    ImageOfSlider(1000L,"slider images/image_1.png"),
        ImageOfSlider(2000L,"slider images/image_2.png"),
        ImageOfSlider(3000L,"slider images/image_3.png"),
        ImageOfSlider(4000L,"slider images/image_4.png"),
        ImageOfSlider(5000L,"slider images/image_5.png"),
        ImageOfSlider(6000L,"slider images/image_6.png"),
    )
    private val homeEpoxyController by lazy {
        HomeEpoxyController()
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
        // Inflate the layout for this fragment
        recyclerView = binding.recyclerViewHome
        recyclerView.adapter = homeEpoxyController.adapter
        layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        homeEpoxyController.setData(myList)
    }
}