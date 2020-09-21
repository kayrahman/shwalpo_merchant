package neel.com.shwalpomerchant.customer.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import neel.com.shwalpomerchant.R
import neel.com.shwalpomerchant.databinding.CustomerHomeFragmentBinding
import neel.com.shwalpomerchant.customer.ui.viewModel.CustomerHomeViewModel

class CustomerHomeFragment : Fragment() {

    companion object {
        fun newInstance() =
            CustomerHomeFragment()
    }

    private lateinit var binding: CustomerHomeFragmentBinding
    private val viewModel: CustomerHomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.customer_home_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }

}