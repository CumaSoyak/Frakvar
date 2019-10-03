package farkvar.com.ui.checkin


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import farkvar.com.R
import farkvar.com.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class CheckInFragment : BaseFragment(), ICheckInNavigator {
    override val layoutId: Int
        get() = R.layout.fragment_check_in
    private val viewModel by viewModel<CheckInViewModel>()

    override fun initNavigator() {
        viewModel.setNavigator(this)
    }

    override fun initUI() {
    }

    override fun initListener() {
    }


}
