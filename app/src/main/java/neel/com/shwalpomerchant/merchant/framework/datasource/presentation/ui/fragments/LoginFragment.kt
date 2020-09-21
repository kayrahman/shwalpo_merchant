package neel.com.shwalpomerchant.merchant.framework.datasource.presentation.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import neel.com.shwalpomerchant.R
import neel.com.shwalpomerchant.databinding.LoginFragmentBinding
import neel.com.shwalpomerchant.merchant.framework.datasource.presentation.ui.viewModels.DashboardViewModel
import neel.com.shwalpomerchant.merchant.framework.datasource.presentation.ui.viewModels.DashboardViewModel.AuthenticationState.*

class LoginFragment : Fragment() {

    private val viewModel: DashboardViewModel by viewModels()
    private lateinit var binding : LoginFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
         binding = DataBindingUtil.inflate(
            inflater, R.layout.login_fragment, container, false
        )

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupListener()
        observeViewModel()

    }

    private fun observeViewModel() {

        viewModel.authenticationState.observe(viewLifecycleOwner, Observer { authenticationState ->
            when (authenticationState) {
                AUTHENTICATED -> findNavController().popBackStack()
                INVALID_AUTHENTICATION -> {}

                else -> Log.e(
                    "Login_state",
                    "Authentication state that doesn't require any UI change $authenticationState"
                )
            }
        })
    }

    private fun setupListener() {
        binding.loginButton.setOnClickListener {
            signinWithEmailPw()
        }
    }

    private fun signinWithEmailPw() {
        val email = binding.etEmail.text.toString().trim()
        val pw = binding.etPw.text.toString().trim()

        if(email.isNotEmpty() && pw.isNotEmpty()){
            viewModel.userLiveData.signinWithEmailPw(email,pw)
        }

    }

}







