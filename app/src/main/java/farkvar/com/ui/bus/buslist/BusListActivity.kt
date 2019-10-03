package farkvar.com.ui.bus.buslist


import android.annotation.TargetApi
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import com.google.android.material.bottomsheet.BottomSheetDialog
import farkvar.com.R
import farkvar.com.data.remote.model.buslist.koltuksatilabilirlikonaylama.KoltukSatilabilirlikOnaylamaRequest
import farkvar.com.data.remote.model.buslist.seferdetayi.*
import farkvar.com.data.remote.model.buslist.seferlistesi.SeferListesiResponse
import farkvar.com.ui.base.BaseActivity
import farkvar.com.data.remote.model.buslist.seferlistesi.Table
import farkvar.com.ui.bus.buslist.adapter.BusAdapter
import farkvar.com.ui.bus.buslist.adapter.CustomKolltuk
import farkvar.com.ui.bus.buslist.adapter.TicketListener
import farkvar.com.ui.bus.buslist.adapter.BusKoltukListener
import farkvar.com.ui.bus.buslist.filtrele.FiltreleDialog
import farkvar.com.ui.main.MainActivity
import farkvar.com.ui.payment.paymentInfo.PaymentInfoActivity
import farkvar.com.utils.AppConstants.DATE
import farkvar.com.utils.AppConstants.TRAVEL_COUNT
import farkvar.com.utils.AppConstants.codeEndCity
import farkvar.com.utils.AppConstants.codeFromCity
import farkvar.com.utils.customscreen.IDataSelectted
import farkvar.com.utils.extensions.launchActivity
import farkvar.com.utils.extensions.toDateFormat
import kotlinx.android.synthetic.main.activity_bus_list.*
import kotlinx.android.synthetic.main.dialog_filtrele.view.*
import kotlinx.android.synthetic.main.ticket_details_bottom_sheet.view.*
import kotlinx.android.synthetic.main.ticket_details_bottom_sheet.view.cancel
import org.koin.androidx.viewmodel.ext.android.viewModel


class BusListActivity : BaseActivity(), IBusListNavigator, TicketListener, IDataSelectted, BusKoltukListener {


    override val layoutId: Int
        get() = R.layout.activity_bus_list

    private val viewModel by viewModel<BusListViewModel>()

    private val busAdapter by lazy { BusAdapter(arrayListOf(), this) }

    val busListListModel: ArrayList<SeferListesiResponse> = arrayListOf()

    var getFromID: String? = null
    var getStartCity: String? = null
    var getEndCity: String? = null
    var getEndID: String? = null
    var getDate: String? = null
    var getTravelCount: String? = null

    override fun initNavigator() {
        viewModel.setNavigator(this)
    }

    override fun initUI() {

        getFromID = intent?.getStringExtra(codeFromCity.toString())
        getStartCity = intent?.getStringExtra("start")
        getEndCity = intent?.getStringExtra("end")
        getEndID = intent?.getStringExtra(codeEndCity.toString())
        getDate = intent?.getStringExtra(DATE)
        getTravelCount = intent?.getStringExtra(TRAVEL_COUNT)
        start_station.text = getStartCity
        end_station.text = getEndCity
        observerData()
        viewModel.seferListesi(getFromID!!.toInt(), getEndID!!.toInt(), getDate!!, getTravelCount!!.toInt())
    }

    override fun initListener() {
        sorting.setOnClickListener {
            sortingDetaisBottomSheet()
        }
        iv_back.setOnClickListener {
            launchActivity<MainActivity> { }
        }
        date_bus.setOnClickListener {
            getDate(this)
        }
        filtre.setOnClickListener {
            FiltreleDialog.newInstance(12)
                .show(supportFragmentManager.beginTransaction(), "KULLANIM_KOSULLARI")
        }
    }
    fun observerData() {
        viewModel.seferListesiData.observe(this, Observer { initData(it) })
    }

    private fun initData(data: ArrayList<Table>?) {
        recylerview.adapter = busAdapter
        data?.let { busAdapter.add(it) }
    }

    override fun onClickListener(model: Table) {
        viewModel.seferDetayi(model.seferTakipNo)
    }

    override fun getSeferDetayiSucces(
        sefer: SeferDetayiSefer?,
        koltuk: ArrayList<SeferDetayiKoltuk>?,
        seyahatTipleri: ArrayList<SeferDetayiSeyehatTipleri>?,
        oTipOzellik: ArrayList<SeyahatDetayOTipOzellik>?,
        odemeKurallari: SeferDetayOdemeKurallari?
    ) {
        var mydialog = BottomSheetDialog(this)
        val view = layoutInflater.inflate(R.layout.ticket_details_bottom_sheet, null)
        mydialog.setContentView(view)
        view.start_station.text = sefer?.kalkisAdi + " > " + sefer?.varisAdi
        view.start_time.text = sefer?.yerelTarihSaat?.substring(11, 16)
        view.total_time.text = sefer?.yaklasikSeyahatSuresi
        view.price.text = sefer?.biletFiyatiInternet + " TL"
        view.chair_option.text = "2+1" //todo burası yok

        val adapter by lazy { CustomKolltuk(koltuk!!, this) }
        view.recylerview.adapter = adapter


        ticketDetailsBottomSheet(view, mydialog)
        mydialog.show()
    }


    private fun ticketDetailsBottomSheet(view: View, dialog: BottomSheetDialog) {
         view.cancel.setOnClickListener {
            dialog.hide()

        }
        view.next.setOnClickListener {
            launchActivity<PaymentInfoActivity> { }
        }

    }

    override fun selectedDate(date: String) {
        date_bus.text = toDateFormat(date)
        viewModel.seferListesi(getFromID!!.toInt(), getEndID!!.toInt(), date, getTravelCount!!.toInt())

    }

    override fun satisOnay(number1: Int, gender1: String, number2: Int, gender2: String) {
        val request = KoltukSatilabilirlikOnaylamaRequest(number1, gender1, number2, gender2)
        viewModel.koltukSatılabilirlikOnay(1, request)
    }

}


