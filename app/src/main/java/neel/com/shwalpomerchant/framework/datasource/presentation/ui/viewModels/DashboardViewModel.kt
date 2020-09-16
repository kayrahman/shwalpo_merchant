package neel.com.shwalpomerchant.framework.datasource.presentation.ui.viewModels

import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import neel.com.shwalpomerchant.framework.datasource.network.FirebaseUserLiveData

class DashboardViewModel : ViewModel() {


    val userLiveData = FirebaseUserLiveData()

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