package farkvar.com.ui.base

import android.os.Bundle
import android.util.Log
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import farkvar.com.R
import farkvar.com.utils.DialogUtils.showPopupSuccess
import farkvar.com.utils.customscreen.CustomDate
import farkvar.com.utils.customscreen.IDataSelectted
import farkvar.com.utils.customscreen.LoadingDialog
import kotlinx.android.synthetic.main.date_bottom_sheet.view.*
import kotlinx.android.synthetic.main.date_bottom_sheet.view.cancel
import kotlinx.android.synthetic.main.ticket_details_bottom_sheet.view.*

abstract class BaseActivity : AppCompatActivity(), IBaseNavigator {
    @get:LayoutRes
    abstract val layoutId: Int?

    protected abstract fun initNavigator()
    protected abstract fun initUI()
    protected abstract fun initListener()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layoutId?.let { setContentView(it) }
        initNavigator()
        initUI()
        initListener()
        Log.d("LIFECYCLE", "onCreate")
    }


    val dialog: AlertDialog by lazy {
        LoadingDialog.Builder().setContext(this)
            .setCancelable(false)
            .setTheme(R.style.LoadingDialogDefault)
           // .setTheme(R.style.SpotsDialog)
            .build()

    }


    override fun showLoading() {
        dialog.show()
    }

    override fun hideLoading() {
        dialog.dismiss()
    }
    fun sortingDetaisBottomSheet() {
        val dialog = BottomSheetDialog(this)
        val view = layoutInflater.inflate(R.layout.sorting_bottom_sheet, null)
        dialog.setContentView(view)
        view.cancel.setOnClickListener { dialog.hide() }
        dialog.show()
    }
    fun getDate(listener:IDataSelectted){
        val dialog = BottomSheetDialog(this!!)
        val view = layoutInflater.inflate(R.layout.date_bottom_sheet, null)
        dialog.setContentView(view)
        view.cancel.setOnClickListener {
            dialog.dismiss()
        }
        CustomDate.customGetDate(this!!, view.datePicker, dialog,listener)
        dialog.show()
    }

    override fun onError(message: String, code: Int) {
        showPopupSuccess(this, message)
    }

    override fun onSucces(message: String) {
        showPopupSuccess(this, message)

    }

    override fun onBackPressed() {
        super.onBackPressed()
     }



}