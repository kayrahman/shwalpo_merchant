package neel.com.shwalpomerchant.framework.datasource.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.firebase.ui.auth.AuthUI
import com.google.android.material.snackbar.Snackbar
import neel.com.shwalpomerchant.R
import neel.com.shwalpomerchant.databinding.DashboardFragmentBinding
import neel.com.shwalpomerchant.framework.datasource.presentation.ui.viewModels.DashboardViewModel
import neel.com.shwalpomerchant.framework.datasource.presentation.ui.viewModels.DashboardViewModel.AuthenticationState.*

class DashboardFragment : Fragment() {

    companion object {
        fun newInstance() =
            DashboardFragment()
    }

    private val viewModel: DashboardViewModel by viewModels()
    private lateinit var binding: DashboardFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.dashboard_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupListener()
        observeViewModel()

    }

    private fun observeViewModel() {


        // handles login
        viewModel.authenticationState.observe(viewLifecycleOwner, Observer { authenticationState ->
            when (authenticationState) {
                AUTHENTICATED -> {

                }
                else -> {

                        findNavController().navigate(R.id.loginFragment)
                    }
                }

        })
    }

    private fun setupListener() {

    }

}