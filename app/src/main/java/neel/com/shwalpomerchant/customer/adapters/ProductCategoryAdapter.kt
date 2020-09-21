package neel.com.shwalpomerchant.customer.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import neel.com.shwalpomerchant.R
import neel.com.shwalpomerchant.customer.model.CategoryItem
import neel.com.shwalpomerchant.customer.ui.viewModel.ProductCategoryAdapterViewModel
import neel.com.shwalpomerchant.databinding.ItemProductCategoryHorizontalBinding

class ProductCategoryAdapter:RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private var categoryItems = listOf<CategoryItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding : ItemProductCategoryHorizontalBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.item_product_category_horizontal,parent,false)

        return ProductCategoryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return categoryItems.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ProductCategoryViewHolder).bind(categoryItems[position])
    }

    fun updateProductCategory(list: List<CategoryItem>){
        this.categoryItems = list
    }

    class ProductCategoryViewHolder(val binding:ItemProductCategoryHorizontalBinding):RecyclerView.ViewHolder(binding.root){
        private val productCategoryAdapterViewModel = ProductCategoryAdapterViewModel()
        fun bind(category:CategoryItem){
            productCategoryAdapterViewModel.bind(category)
            binding.viewModel = productCategoryAdapterViewModel
        }
    }

}