package farkvar.com.ui.search


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import farkvar.com.R
import farkvar.com.data.remote.model.buslist.karanoktalari.KaraNoktalari
import farkvar.com.ui.base.BaseActivity
import farkvar.com.ui.base.BaseFragment
import farkvar.com.ui.bus.buslist.BusListActivity
import farkvar.com.ui.search.adapter.IKaraNoktaInterface
import farkvar.com.ui.search.adapter.SearchAdapter
import farkvar.com.utils.AppConstants
import farkvar.com.utils.AppConstants.codeEndCity
import farkvar.com.utils.AppConstants.codeFromCity
import kotlinx.android.synthetic.main.fragment_search_air.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class SearchActivity : BaseActivity(), ISearchNavigator, IKaraNoktaInterface {

    override val layoutId: Int
        get() = R.layout.fragment_search_air

    private val viewModel by viewModel<SearchViewModel>()
    private val searchAdapter by lazy { SearchAdapter(arrayListOf(), this) }
    var dataList: ArrayList<KaraNoktalari> = arrayListOf()
    var getFromCode: Int? = null
    var getEndCode: Int? = null
    override fun initNavigator() {
        viewModel.setNavigator(this)
    }

    override fun initUI() {
        getFromCode = intent?.getIntExtra(codeFromCity.toString(), 0)
        getEndCode = intent?.getIntExtra(codeEndCity.toString(), 0)
        observerData()
        viewModel.karaNoktalari()
    }

    private fun observerData() {
        viewModel.karaNoktaData.observe(this, Observer { initData(it) })
    }

    private fun initData(data: ArrayList<KaraNoktalari>?) {
        rvKaraNokta.adapter = searchAdapter

        data?.let {
            searchAdapter.add(it)
            dataList = data
        }
    }

    override fun initListener() {
        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                filterList(p0.toString())
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                filterList(p0.toString())
                return true
            }

        }

        )
    }

    override fun karaNoktaClick(model: KaraNoktalari) {
        sendStation(model.Ad.toString(), model.ID.toString())
    }

    fun sendStation(text: String,id:String) {
        if (getFromCode != 0) {
            val intent = Intent()
            intent.putExtra(AppConstants.CITY, text)
            intent.putExtra(AppConstants.CITY_ID, id)
            setResult(codeFromCity, intent)
            finish()
        }
        if (getEndCode != 0) {
            val intent = Intent()
            intent.putExtra(AppConstants.CITY, text)
            intent.putExtra(AppConstants.CITY_ID, id)
            setResult(codeEndCity, intent)
            finish()
        }

    }

    fun filterList(text: String) {
        val filteredCourseAry: ArrayList<KaraNoktalari> = ArrayList()
        for (dieticianItem in this.dataList) {
            if (dieticianItem.Ad!!.toLowerCase().contains(text.toLowerCase())) {
                filteredCourseAry.add(dieticianItem)
            }
        }
        searchAdapter.filterList(filteredCourseAry)
    }


}
