package neel.com.shwalpomerchant.merchant.framework.datasource.presentation.ui.viewModels

import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import neel.com.shwalpomerchant.merchant.framework.datasource.network.FirebaseUserLiveData

class DashboardViewModel : ViewModel() {


    val userLiveData =
        FirebaseUserLiveData()

    enum class AuthenticationState {
        AUTHENTICATED, UNAUTHENTICATED, INVALID_AUTHENTICATION
    }





    val authenticationState = Transformations.map(userLiveData){user->
        if (user != null) {
            AuthenticationState.AUTHENTICATED
        } else {
            AuthenticationState.UNAUTHENTICATED
        }

    }


}