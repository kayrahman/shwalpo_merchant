package neel.com.shwalpomerchant.customer.model




object CustomerHomeModelType {
    const val BANNER = "banner"
    const val CATEGORY = "category"
    const val PRODUCT_LIST = "product_list"
}


interface ICustomerHomeModel {
    val type:String
}