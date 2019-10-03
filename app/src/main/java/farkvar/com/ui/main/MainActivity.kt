package farkvar.com.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import farkvar.com.ui.air.AirFragment
import farkvar.com.ui.bus.bushome.BusFragment

import farkvar.com.R
import farkvar.com.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import android.content.Context
import android.view.*
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.internal.NavigationMenu
import com.google.android.material.internal.NavigationMenuItemView
import com.google.android.material.navigation.NavigationView
import farkvar.com.ui.bus.buslist.filtrele.FiltreleDialog
import farkvar.com.ui.checkin.CheckInFragment
import farkvar.com.ui.yanmenu.*
import farkvar.com.utils.extensions.launchActivity


class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {


    private val viewModel by viewModel<MainViewModel>()

    override val layoutId: Int?
        get() = R.layout.activity_main

    companion object {
        lateinit var drawerLayout: DrawerLayout

    }

    override fun initNavigator() {
        viewModel.setNavigator(this)
    }

    override fun initUI() {
        drawerLayout=findViewById(R.id.drawer_layout)

    }

    override fun initListener() {
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        replaceFragment(BusFragment())
        nav_view.setNavigationItemSelectedListener(this)
    }



    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        menuItem.isChecked = true
        drawer_layout.closeDrawers()
        when (menuItem.itemId) {
            R.id.nav_login -> replaceFragment(AuthFragment())
            R.id.nav_bus -> replaceFragment(BusFragment())
            R.id.nav_about -> replaceFragment(AboutFragment())
            R.id.nav_question -> replaceFragment(SorularFragment())
            R.id.nav_iletisim -> replaceFragment(IletisimFragment())
            R.id.nav_contact -> replaceFragment(TelefonFragment())
        }
        return true
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.checkinmenu -> {
                replaceFragment(CheckInFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.busmenu -> {
                replaceFragment(BusFragment())
                return@OnNavigationItemSelectedListener true
            }

        }
        false
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.main_framelayout, fragment).addToBackStack(null)
        fragmentTransaction.commit()
    }

}
