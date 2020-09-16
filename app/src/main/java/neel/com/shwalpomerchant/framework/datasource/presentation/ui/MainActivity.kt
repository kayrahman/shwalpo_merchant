package neel.com.shwalpomerchant.framework.datasource.presentation.ui

import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import neel.com.shwalpomerchant.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        nav_view.setupWithNavController(nav_host_fragment.findNavController())
        nav_host_fragment.findNavController()
            .addOnDestinationChangedListener{ _, destination, _ ->
                when(destination.id){
                    R.id.dashboardFragment -> nav_view.visibility = View.VISIBLE
                    else -> nav_view.visibility = View.GONE


                }

            }



    }
}