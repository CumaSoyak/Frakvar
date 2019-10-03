package farkvar.com.ui.base

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialog
import farkvar.com.R
import farkvar.com.utils.DialogUtils
import farkvar.com.utils.customscreen.CustomDate
import farkvar.com.utils.customscreen.IDataSelectted
import farkvar.com.utils.customscreen.LoadingDialog
import kotlinx.android.synthetic.main.date_bottom_sheet.view.*
import kotlinx.android.synthetic.main.toolbar.*

abstract class BaseFragment : Fragment(), IBaseNavigator {


    @get:LayoutRes
    abstract val layoutId: Int

    protected abstract fun initNavigator()

    protected abstract fun initUI()

    protected abstract fun initListener()

    private val dialog: AlertDialog by lazy {
        LoadingDialog.Builder().setContext(context!!)
            .setCancelable(false)
            .setTheme(R.style.LoadingDialogDefault)
            //.setTheme(R.style.SpotsDialog)
            .build()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initNavigator()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutId, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        initListener()
        toolbarListener()
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun toolbarListener() {
        logo.setOnClickListener {

        }
        containerNotification.setOnClickListener {
            containerNotification.backgroundTintList=resources.getColorStateList(R.color.mavi)
            ivNotification.imageTintList=resources.getColorStateList(R.color.white)
            DialogUtils.showPopupNotification(context!!,"")
        }
    }

    override fun showLoading() {
        dialog.show()
    }
    fun getDate(listener:IDataSelectted){
        val dialog = BottomSheetDialog(context!!)
        val view = layoutInflater.inflate(R.layout.date_bottom_sheet, null)
        dialog.setContentView(view)
        view.cancel.setOnClickListener {
            dialog.dismiss()
        }
        CustomDate.customGetDate(context!!, view.datePicker, dialog,listener)
        dialog.show()
    }
    override fun hideLoading() {
        dialog.hide()
    }

    override fun onError(message: String, code: Int) {
        //showToast(errorMessage, Toast.LENGTH_LONG)
//        val model = DialogUtils.DialogModel(
//            "",
//            message,
//            0,
//            "Tamam",
//            "",
//            R.drawable.ic_error,
//            false
//        )
//
//        DialogUtils.showAlertDialog(context!!, model, object : DialogUtils.DialogAlertListener {
//            override fun onPositiveClick() {
//            }
//
//            override fun onNegativeClick() {
//            }
//
//        })
    }

    override fun onSucces(message: String) {
     }



}