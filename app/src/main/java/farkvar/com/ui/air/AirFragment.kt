package farkvar.com.ui.air


import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
 import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.fragment.app.Fragment
import farkvar.com.customviews.CalendarFragment
import farkvar.com.Definition.Companion.returnAir
import farkvar.com.Definition.Companion.selectedDay
import farkvar.com.Definition.Companion.selectedMonth
import farkvar.com.Definition.Companion.selectedNameOfDay

import farkvar.com.R
import farkvar.com.ui.search.SearchActivity
import farkvar.com.Travel
import kotlinx.android.synthetic.main.fragment_air.*
import kotlinx.android.synthetic.main.fragment_air.view.*
import java.util.*


class AirFragment : Fragment(), View.OnClickListener, Travel {

    lateinit var nameOfDay: TextView
    lateinit var month: TextView
    lateinit var day: TextView
    lateinit var dialogCount: Dialog
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_air, container, false)
        initView(view)
        printToday()
        chechkReturnTime(view)
        return view
    }

    override fun initView(view: View) {
        nameOfDay = view.findViewById(R.id.name_of_day)
        month = view.findViewById(R.id.month)
        day = view.findViewById(R.id.day)

        view.from_airport.setOnClickListener(this)
        view.change_route_air.setOnClickListener(this)
        view.time_air.setOnClickListener(this)
        view.choose_travel_count.setOnClickListener(this)
        view.find_ticket.setOnClickListener(this)
        view.return_time_air.setOnClickListener(this)
        view.cancel_return_air.setOnClickListener(this)
        view.choose_double_route.setOnClickListener(this)

    }

    override fun onClick(item: View) {
        val itemId = item.id
        when (itemId) {
            R.id.from_airport -> {
               // replaceFragment(SearchActivity())
            }
            R.id.change_route_air -> {
                changeRoute()

            }
            R.id.to_airport -> {

            }
            R.id.time_air -> {
                selectTime()

            }
            R.id.return_time_air -> {
                selectReturnTime()

            }
            R.id.choose_travel_count -> {
                chooseTravelCount()

            }
            R.id.choose_transfer -> {

            }
            R.id.choose_double_route -> {
                selectReturnTime()
            }
            R.id.cancel_return_air -> {
                cancelReturnAir()
            }
            R.id.find_ticket -> {
                replaceFragment(AirListFragment())

            }

        }
    }

    override fun printToday() {
        if (selectedDay == 0 && selectedMonth == null && selectedNameOfDay == null) {
            defaultDate()
        } else {
            nameOfDay.setText(selectedNameOfDay)
            month.setText(selectedMonth)
            day.setText(selectedDay.toString())
        }
    }

    override fun defaultDate() {
        val calendar = Calendar.getInstance()
        val currentDay = calendar.get(Calendar.DAY_OF_WEEK)
        val currentMonthDay = calendar.get(Calendar.DAY_OF_MONTH)
        val currentMonth = calendar.get(Calendar.MONTH)
        val calendarFragment = CalendarFragment()
        //nameOfDay.setText(calendarFragment.getDay(currentDay))
       // month.text = calendarFragment.getMonth(currentMonth + 1)
        day.text = currentMonthDay.toString()

    }

    override fun cancelReturnAir() {
        radiogroup_route.visibility = View.VISIBLE
        return_time_air.visibility = View.GONE

        cancel_return_air.visibility = View.GONE

        choose_single_route.isChecked = true
        choose_double_route.isChecked = false


    }

    override fun chooseTravelCount() {
        dialogCount = Dialog(activity!!, R.style.DialogNotitle)
        dialogCount.setContentView(R.layout.dialog_air_count_statu)
        dialogCount.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialogCount.show()
    }

    override fun selectTime() {
       // replaceFragment(CalendarFragment())
    }

    override fun selectReturnTime() {
        return_time_air.visibility = View.VISIBLE
        cancel_return_air.visibility = View.VISIBLE
        radiogroup_route.visibility = View.GONE
        //replaceFragment(CalendarFragment())
        returnAir = true
    }

    override fun chechkReturnTime(view: View) {
        if (returnAir) {
            view.return_time_air.visibility = View.VISIBLE
            view.cancel_return_air.visibility = View.VISIBLE
            view.radiogroup_route.visibility = View.GONE
        }
    }

    override fun changeRoute() {
        val rotation = AnimationUtils.loadAnimation(activity, R.anim.change_route)
        change_route_air.startAnimation(rotation)
    }

    override fun replaceFragment(fragment: Fragment) {

        fragmentManager!!.beginTransaction().addToBackStack(null)
            .replace(R.id.main_framelayout, fragment).commit()

    }

}
