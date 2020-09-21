package neel.com.shwalpomerchant.customer.ui.viewModel

import neel.com.shwalpomerchant.customer.adapters.ProductCategoryAdapter
import neel.com.shwalpomerchant.customer.model.CategoryItem


class ProductCategoryAdapterViewModel {

    var categoryItem: CategoryItem? = null

    fun bind(category_item: CategoryItem){
        this.categoryItem = category_item
    }

    fun getCategoryName():String{
        return categoryItem?.category_name.toString()
    }

}