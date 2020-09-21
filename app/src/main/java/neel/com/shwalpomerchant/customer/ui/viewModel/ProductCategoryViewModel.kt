package neel.com.shwalpomerchant.customer.ui.viewModel

import neel.com.shwalpomerchant.customer.adapters.ProductCategoryAdapter
import neel.com.shwalpomerchant.customer.model.CategoryItem
import neel.com.shwalpomerchant.customer.model.CategoryItems


class ProductCategoryViewModel {

    val prodCategoryAdapter = ProductCategoryAdapter()

    fun bind(list: CategoryItems){
        prodCategoryAdapter.updateProductCategory(list.list)
    }

}