package neel.com.shwalpomerchant.merchant.framework.datasource.presentation.ui.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import neel.com.shwalpomerchant.R
import neel.com.shwalpomerchant.merchant.framework.datasource.presentation.ui.viewModels.OrdersViewModel

class OrdersFragment : Fragment() {

    companion object {
        fun newInstance() =
            OrdersFragment()
    }

    private lateinit var viewModel: OrdersViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.orders_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(OrdersViewModel::class.java)
        // TODO: Use the ViewModel
    }

}