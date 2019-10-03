package farkvar.com
 import android.view.View
 import androidx.fragment.app.Fragment

interface Travel {
    fun initView(view: View)


    fun printToday()

    fun defaultDate()

    fun cancelReturnAir()

    fun chooseTravelCount()

    fun selectTime()

    fun selectReturnTime()

    fun chechkReturnTime(view: View)

    fun changeRoute()

    fun replaceFragment(fragment: Fragment)
}