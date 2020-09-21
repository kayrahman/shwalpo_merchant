package neel.com.shwalpomerchant.customer.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import neel.com.shwalpomerchant.R
import neel.com.shwalpomerchant.customer.model.CategoryItem
import neel.com.shwalpomerchant.customer.model.CategoryItems

import neel.com.shwalpomerchant.customer.model.CustomerHomeModelType
import neel.com.shwalpomerchant.customer.model.ICustomerHomeModel
import neel.com.shwalpomerchant.databinding.LayoutProductCategoryBinding
import neel.com.shwalpomerchant.customer.ui.viewModel.ProductCategoryViewModel


class CustomerHomeModelAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private val BANNER_ITEM = 0
    private val CATEGORY_ITEM = 1
    private val PRODUCT_ITEM = 2

    private var list = listOf<ICustomerHomeModel>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
          return when(viewType){
                CATEGORY_ITEM -> {
                    val binding:LayoutProductCategoryBinding = DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.layout_product_category, parent, false)

                      CategoriesViewHolder(binding,parent.context)
                }

              else ->{
                  val binding:LayoutProductCategoryBinding = DataBindingUtil.inflate(
                      LayoutInflater.from(parent.context),
                      R.layout.layout_product_category, parent, false)

                  CategoriesViewHolder(binding,parent.context
                  )
              }


            }
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            when(holder.itemViewType){
                CATEGORY_ITEM -> {
                    val viewHolder = holder as CategoriesViewHolder
                    viewHolder.bind(list[position] as CategoryItems)
                }
            }
    }

    override fun getItemViewType(position: Int): Int {
        return when(list[position].type){
            CustomerHomeModelType.BANNER -> BANNER_ITEM
            CustomerHomeModelType.CATEGORY -> CATEGORY_ITEM
            else -> PRODUCT_ITEM
        }
    }

    fun updateCustomerModelAdapter(homeModels:List<ICustomerHomeModel>){
        this.list = homeModels
    }


    class CategoriesViewHolder(val binding : LayoutProductCategoryBinding,val context:Context) : RecyclerView.ViewHolder(binding.root){
        val categoryViewModel = ProductCategoryViewModel()

        fun bind(categoryItems : CategoryItems ){
            binding.viewModel = categoryViewModel
            categoryViewModel.bind(categoryItems)

            binding.rvItemCategory.layoutManager = LinearLayoutManager(context)
            binding.rvItemCategory.adapter = categoryViewModel.prodCategoryAdapter

        }
    }



}