package com.amrabdelhamiddiab.pharmacy_1.presentation.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.epoxy.EpoxyRecyclerView
import com.amrabdelhamiddiab.core.data.IPreferenceHelper
import com.amrabdelhamiddiab.core.domain.ImageOfSlider
import com.amrabdelhamiddiab.core.domain.Offer
import com.amrabdelhamiddiab.pharmacy_1.MainActivity.Companion.TAG
import com.amrabdelhamiddiab.pharmacy_1.R
import com.amrabdelhamiddiab.pharmacy_1.databinding.FragmentHomeBinding
import com.amrabdelhamiddiab.pharmacy_1.framework.utilis.LoginFlowViewModelFactory
import com.amrabdelhamiddiab.pharmacy_1.framework.utilis.PreferenceManager

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var preferenceHelper: IPreferenceHelper
    //Note epoxy recycler view doesn't update the inner
    // recycler views,so i used normal recycler view
    private lateinit var recyclerView: RecyclerView
    private lateinit var layoutManager: LinearLayoutManager
    private val myList: List<ImageOfSlider>? = listOf(
        ImageOfSlider("1000", "slider images/image_1.png"),
        ImageOfSlider("2000", "slider images/image_2.png"),
        ImageOfSlider("3000", "slider images/image_3.png"),
        ImageOfSlider("4000", "slider images/image_4.png"),
        ImageOfSlider("5000", "slider images/image_5.png"),
        ImageOfSlider("6000", "slider images/image_6.png"),
    )
    private val homeEpoxyController by lazy {
        HomeEpoxyController(viewModel)
    }
    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this, LoginFlowViewModelFactory)[HomeViewModel::class.java]
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
        Log.d(TAG, "******activity")
        // Inflate the layout for this fragment
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
    /*    viewModel.listOfOffers.observe(viewLifecycleOwner) {
            homeEpoxyController.setData(viewModel.listOfOfImagesOfSlider.value, it)
            //  recyclerView.adapter = homeEpoxyController.adapter
            Log.d(TAG, "6565656565656565656565" + it.toString())
        }
        viewModel.listOfOfImagesOfSlider.observe(viewLifecycleOwner){
         //   homeEpoxyController.setData(it, viewModel.listOfOffers.value)
            homeEpoxyController.d
        }*/
        viewModel.pairMediatorLiveData.observe(viewLifecycleOwner){
           val(a,b) = it
            Log.d(TAG, "AAAAA"+ a.toString() +"BBBBB"+ b.toString())
            if (a != null && b!= null){
                homeEpoxyController.setData(b, a)
                Log.d(TAG, "Inside ab pair33333333333333333333333333")
            }else{
                Log.d(TAG, "ONE is error")
               /* val a1 = listOf(Offer(medicine_image_url = "slider images/image_1.png"))
                val b1 = listOf(ImageOfSlider(imageUrl = "slider images/image_1.png"))*/
                val a1 = listOf(Offer())
                val b1 = listOf(ImageOfSlider(imageUrl = "slider images/image_1.png"))
                homeEpoxyController.setData(b1, a1)
            }
        }
     //   viewModel.downloadImagesOfSlider()
      //  viewModel.downloadOffers()
        viewModel.downloadHomeContents()
        return binding.root
    }

}