package com.amrabdelhamiddiab.pharmacy_1.presentation.login

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
import com.amrabdelhamiddiab.core.data.IPreferenceHelper
import com.amrabdelhamiddiab.pharmacy_1.MainActivity
import com.amrabdelhamiddiab.pharmacy_1.MainActivity.Companion.TAG
import com.amrabdelhamiddiab.pharmacy_1.R
import com.amrabdelhamiddiab.pharmacy_1.databinding.FragmentLoginBinding
import com.amrabdelhamiddiab.pharmacy_1.framework.utilis.PharmacyViewModelFactory
import com.amrabdelhamiddiab.pharmacy_1.framework.utilis.PreferenceManager
import com.amrabdelhamiddiab.pharmacy_1.framework.utilis.checkInternetConnection
import com.amrabdelhamiddiab.pharmacy_1.presentation.LoginFlowViewModel
import com.google.firebase.auth.FirebaseAuth
import com.wajahatkarim3.easyvalidation.core.view_ktx.validator

class LoginFragment : Fragment() {
    private val viewModel: LoginFlowViewModel by navGraphViewModels(R.id.nested_graph_login) {
        PharmacyViewModelFactory
    }
    private lateinit var binding: FragmentLoginBinding
    private var validPassword: Boolean = false
    private var validEmail: Boolean = false
    private lateinit var preferenceHelper: IPreferenceHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        preferenceHelper = PreferenceManager(requireActivity().applicationContext)
        viewModel.downloading.observe(viewLifecycleOwner) {
            if (it) {
                binding.loadingIndecatorLogin.visibility = View.VISIBLE
            } else {
                binding.loadingIndecatorLogin.visibility = View.GONE
            }
        }
        viewModel.userSignedIn.observe(viewLifecycleOwner) {
            if (it == true) {
                Log.d(TAG, "userSigned in but we still don't know if he verified email")
                viewModel.isEmailVerified()
            } else {
                preferenceHelper.setUserLoggedIn(false)
            }
        }
        viewModel.emailVerified.observe(viewLifecycleOwner) {
            if (it == true) {
                preferenceHelper.setUserLoggedIn(true)
                findNavController().navigate(R.id.action_global_nested_graph_home)
            } else {
                if (checkInternetConnection(requireContext())) {
                    Toast.makeText(requireContext(), "Please Verify your Email", Toast.LENGTH_SHORT)
                        .show()
                    Log.d(TAG, "Please Verify your Email")
                } else {
                    Toast.makeText(
                        requireContext(),
                        "No Network please turn on",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
        binding.buttonLogin.setOnClickListener {
            validateEmailField()
            validatePasswordField()
            if (validEmail && validPassword) {
                val email = binding.editTextLoginEmail.text.toString()
                val password = binding.editTextLoginPassword.text.toString()
                if (checkInternetConnection(requireContext())) {
                    viewModel.signIn(email, password)
                } else {
                    Toast.makeText(
                        requireContext(),
                        "No Network please turn on",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            } else {
                //may use singleLiveEvent
                Toast.makeText(requireContext(), "** INVALID CREDENTIALS **", Toast.LENGTH_LONG)
                    .show()
            }
        }
        binding.tvLoginForgetPasswordClickable.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_resetPasswordFragment)
        }
        binding.tvLoginSignupClickable.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signupFragment)
        }
        // Inflate the layout for this fragment
        Log.d(TAG, FirebaseAuth.getInstance().currentUser?.email.toString())
        // Inflate the layout for this fragment
        return binding.root
    }
    private fun validateEmailField() {
        binding.editTextLoginEmail.validator().nonEmpty().validEmail().addErrorCallback {
            validEmail = false
            binding.textLayoutLoginEmail.error = it
            Log.d(TAG, it)
        }.addSuccessCallback {
            validEmail = true
            binding.textLayoutLoginEmail.error = null
        }.check()
    }
    private fun validatePasswordField() {
        binding.editTextLoginPassword.validator().nonEmpty().addErrorCallback {
            validPassword = false
            binding.textLayoutLoginPassword.error = it
            Log.d(TAG, it)
        }.addSuccessCallback {
            validPassword = true
            binding.textLayoutLoginPassword.error = null
        }.check()
    }

    override fun onResume() {
        super.onResume()
        (activity as MainActivity).setDrawerLocked()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        (activity as MainActivity).setDrawerUnlocked()
    }
}