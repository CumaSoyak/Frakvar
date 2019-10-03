package farkvar.com.ui.bus.bushome


import android.content.Intent
import androidx.core.view.GravityCompat

import farkvar.com.R
import farkvar.com.Travel
import farkvar.com.data.remote.model.buslist.seferdetayi.*
import farkvar.com.ui.base.BaseFragment
import farkvar.com.ui.bus.buslist.BusListActivity
import farkvar.com.ui.bus.buslist.BusListViewModel
import farkvar.com.ui.bus.buslist.IBusListNavigator
import farkvar.com.ui.main.MainActivity
import farkvar.com.ui.search.SearchActivity
import farkvar.com.utils.AppConstants
import farkvar.com.utils.AppConstants.CITY
import farkvar.com.utils.AppConstants.CITY_ID
import farkvar.com.utils.AppConstants.DATE
import farkvar.com.utils.AppConstants.TRAVEL_COUNT
import farkvar.com.utils.AppConstants.codeEndCity
import farkvar.com.utils.AppConstants.codeFromCity
import farkvar.com.utils.customscreen.CustomDate.customGetDate
import farkvar.com.utils.customscreen.IDataSelectted
import farkvar.com.utils.extensions.launchActivity
import farkvar.com.utils.extensions.load
import farkvar.com.utils.extensions.toDateMonthOfYearAndDay
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.date_bottom_sheet.view.*
import kotlinx.android.synthetic.main.fragment_bus.*
import kotlinx.android.synthetic.main.toolbar.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class BusFragment : BaseFragment(), IDataSelectted, IBusNavigator {


    override val layoutId: Int
        get() = R.layout.fragment_bus

    private val viewModel by viewModel<BusViewModel>()

    interface MenuListener {
        fun click()
    }

    companion object {
        var startId: String? = null
        var startCityText: String? = null
        var endId: String? = null
        var endCityText: String? = null
        var time: String? = null
        var travelCount = "1"
        var mDay: String? = null
        var mMonth: String? = null
        var mNameOfDay: String? = null
    }

    override fun initNavigator() {
        viewModel.setNavigator(this)
    }

    override fun initUI() {
        if (checKInput()) {
            start_city.text = startCityText
            end_city.text = startCityText
            day.text = startCityText
            month.text = startCityText
            name_of_day.text = startCityText
            day.text = mDay
            month.text = mMonth
            name_of_day.text = mNameOfDay
         }
    }


    override fun initListener() {
        find_ticket_bus.setOnClickListener {

            context!!.launchActivity<BusListActivity> {
                putExtra(codeFromCity.toString(), "738")
                putExtra(codeEndCity.toString(), "84")
                putExtra("start", "Kayseri")
                putExtra("end", "Ankara")
                putExtra(DATE, time)
                putExtra(TRAVEL_COUNT, "1")
            }


        }
        start_station.setOnClickListener {
            val intent = Intent(context, SearchActivity::class.java)
            intent.putExtra(codeFromCity.toString(), codeFromCity)
            startActivityForResult(intent, codeFromCity)
        }
        end_station.setOnClickListener {
            val intent = Intent(context, SearchActivity::class.java)
            intent.putExtra(codeEndCity.toString(), codeEndCity)
            startActivityForResult(intent, codeEndCity)
        }
        time_bus.setOnClickListener {
            getDate(this)
        }
        drawable_button.setOnClickListener {
            MainActivity.drawerLayout.openDrawer(GravityCompat.START)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == codeFromCity && data != null) {
            startCityText = data.getStringExtra(CITY)
            startId = data.getStringExtra(CITY_ID)
            start_city.text = startCityText

        }
        if (requestCode == codeEndCity && data != null) {
            endCityText = data.getStringExtra(CITY)
            endId = data.getStringExtra(CITY_ID)
            end_city.text = endCityText
        }
    }

    override fun selectedDate(date: String) {
        time = date
        val listDate = toDateMonthOfYearAndDay(date)
        mDay = listDate.get(0)
        mMonth = listDate.get(1)
        mNameOfDay = listDate.get(2)
        day.text = mDay
        month.text = mMonth
        name_of_day.text = mNameOfDay

    }

    fun checKInput(): Boolean {
        if (!time.isNullOrEmpty())
            return true
        if (!startId.isNullOrEmpty())
            return true
        if (!endId.isNullOrEmpty())
            return true
        return false
    }

}
