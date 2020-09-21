package neel.com.shwalpomerchant.customer.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize



data class BannerItem(val image_url: String = "",
                      override val type: String=CustomerHomeModelType.BANNER

) : ICustomerHomeModel



@Parcelize
data class CategoryItem(
    var uid: String,
    val category_name: String,
    val img_url: String,
    override val type: String=CustomerHomeModelType.CATEGORY
    //  var sub_categories:List<SubCategoryItem>?,

): Parcelable, ICustomerHomeModel

