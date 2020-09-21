package neel.com.shwalpomerchant.merchant.framework.datasource.presentation.ui.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.marginRight
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import com.github.mikephil.charting.utils.MPPointF
import kotlinx.android.synthetic.main.dashboard_fragment.view.*
import neel.com.shwalpomerchant.R
import neel.com.shwalpomerchant.databinding.DashboardFragmentBinding
import neel.com.shwalpomerchant.merchant.business.listeners.INavigationMenuListeners
import neel.com.shwalpomerchant.merchant.framework.datasource.presentation.ui.viewModels.DashboardViewModel
import neel.com.shwalpomerchant.merchant.framework.datasource.presentation.ui.viewModels.DashboardViewModel.AuthenticationState.AUTHENTICATED
import java.util.*

class DashboardFragment : Fragment() {

    companion object {
        fun newInstance() =
            DashboardFragment()
    }

    private val viewModel: DashboardViewModel by viewModels()
    private lateinit var binding: DashboardFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.dashboard_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupListener()
        observeViewModel()
        navigationItemCLick()

        setPieData()

    }

    private fun setPieData() {

        val chart:PieChart = binding.pieChart.pie_chart as PieChart

        popChart(chart)

        val legends = arrayOf("Pending","Confirmed","Processing","Picked","Shipped","Delivered")

        val entries = ArrayList<PieEntry>()

        entries.add(PieEntry(145f,legends[0]+":"+145))
        entries.add(PieEntry(145f,legends[1]+":"+145))
        entries.add(PieEntry(245f,legends[2]))
        entries.add(PieEntry(145f,legends[3]))
        entries.add(PieEntry(245f,legends[4]))
        entries.add(PieEntry(345f,legends[5]))


       /*
        for (element in legends) {
            entries.add(
                PieEntry(
                    legends.size.toFloat(), element
                )
            )
        }*/


        val dataSet = PieDataSet(entries, "Orders")

        dataSet.setDrawIcons(false)

        dataSet.sliceSpace = 3f
        dataSet.iconsOffset = MPPointF(0.toFloat(), 40.toFloat())
        dataSet.selectionShift = 8f


        // add a lot of colors
        val colors = ArrayList<Int>()

        for (c in ColorTemplate.VORDIPLOM_COLORS) colors.add(c)

        for (c in ColorTemplate.JOYFUL_COLORS) colors.add(c)

        for (c in ColorTemplate.COLORFUL_COLORS) colors.add(c)

        for (c in ColorTemplate.LIBERTY_COLORS) colors.add(c)

        for (c in ColorTemplate.PASTEL_COLORS) colors.add(c)

        colors.add(ColorTemplate.getHoloBlue())

        dataSet.colors = colors


        //dataSet.setSelectionShift(0f);
        val data = PieData(dataSet)
        data.setValueFormatter(PercentFormatter(chart))
        data.setValueTextSize(11f)
        data.setValueTextColor(Color.WHITE)
       // data.setValueTypeface(tfLight)
        chart.setData(data)

        // undo all highlights

        // undo all highlights
        chart.highlightValues(null)

        chart.invalidate()


    }

    private fun popChart(chart: PieChart) {
        chart.setUsePercentValues(true)
        chart.description.isEnabled = false

       // chart.setExtraOffsets(50f, 10f, 50f, 50f)


        chart.dragDecelerationFrictionCoef = 0.95f

     //   chart.setCenterTextTypeface(tfLight)
      //  chart.centerText = generateCenterSpannableText()
        chart.centerText = "Orders"

        chart.isDrawHoleEnabled = true
        chart.setHoleColor(Color.WHITE)

        chart.setTransparentCircleColor(Color.WHITE)
        chart.setTransparentCircleAlpha(110)

        chart.holeRadius = 38f
        chart.transparentCircleRadius = 41f

        chart.setDrawCenterText(true)

        chart.rotationAngle = 0f

        // enable rotation of the chart by touch
        chart.isRotationEnabled = true
        chart.isHighlightPerTapEnabled = true


        chart.animateY(1400, Easing.EaseInOutQuad)

        val l = chart.legend
        l.verticalAlignment = Legend.LegendVerticalAlignment.CENTER
        l.horizontalAlignment = Legend.LegendHorizontalAlignment.RIGHT
        l.orientation = Legend.LegendOrientation.VERTICAL
        l.setDrawInside(false)
      //  l.formSize = 20F
       // l.formToTextSpace = 5f
       // l.form = Legend.LegendForm.SQUARE
     //   l.xEntrySpace = -20f
       // l.yEntrySpace = 0f
        l.xOffset = 20f
        l.yOffset = -20f

        // entry label styling
        chart.setEntryLabelColor(Color.WHITE)
       // chart.setEntryLabelTypeface(tfRegular)
        chart.setEntryLabelTextSize(12f)

    }

    fun navigationItemCLick(){
        val nav_item_listener = object:
            INavigationMenuListeners {
            override fun onNavigationMenuItemClick(v: View) {
            when(v.id){
                R.id.ll_order -> {
                    //go to order fragment
                    findNavController().navigate(R.id.action_dashboardFragment_to_ordersFragment)
                }

                R.id.ll_newsfeed ->{

                }

                R.id.ll_settings ->{
                    findNavController().navigate(R.id.action_dashboardFragment_to_settingsFragment)
                }

                R.id.customerApp ->{
                    findNavController().navigate(R.id.action_dashboardFragment_to_customerHomeFragment)
                }


            }
            }

        }

         binding.navItem.navigationMenuHandler = nav_item_listener
     }

    private fun observeViewModel() {


        // handles login
        viewModel.authenticationState.observe(viewLifecycleOwner, Observer { authenticationState ->
            when (authenticationState) {
                AUTHENTICATED -> {

                }
                else -> {

                        findNavController().navigate(R.id.loginFragment)
                    }
                }

        })
    }

    private fun setupListener() {

    }

}