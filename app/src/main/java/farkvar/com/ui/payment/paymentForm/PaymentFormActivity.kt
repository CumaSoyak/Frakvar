package farkvar.com.ui.payment.paymentForm

import farkvar.com.R
import farkvar.com.data.remote.model.userformmodel.UserFormModel
import farkvar.com.ui.base.BaseActivity
import farkvar.com.ui.payment.paymentForm.adapter.UserFromAdapter
import farkvar.com.ui.payment.paymentForm.viewholder.GetInfo
import farkvar.com.ui.payment.paymentcash.PaymentCashActivity
import farkvar.com.utils.extensions.launchActivity
import kotlinx.android.synthetic.main.activity_payment_form.*
import kotlinx.android.synthetic.main.page_toolbar.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class PaymentFormActivity : BaseActivity(), GetInfo {


    override val layoutId: Int?
        get() = R.layout.activity_payment_form

    private val viewModel by viewModel<PaymentFormViewModel>()
    private val adapter by lazy { UserFromAdapter(arrayListOf(), this) }
    var dataList: ArrayList<UserFormModel> = arrayListOf()
    var listInfoName: ArrayList<String>? = ArrayList()
    var listInfoSurname: ArrayList<String>? = ArrayList()
    var listInfoTcId: ArrayList<String>? = ArrayList()


    override fun initNavigator() {
        viewModel.setNavigator(this)
    }

    override fun initUI() {
        recylerview.adapter = adapter
        dataList.add(UserFormModel("dasdasd"))
        dataList.add(UserFormModel("dasdasd"))
        dataList.add(UserFormModel("dasdasd"))
        dataList.add(UserFormModel("dasdasde"))
        adapter.add(dataList)
        for (x in 0 until dataList.size)
        {
            listInfoName?.add(x,"default")
            listInfoSurname?.add(x,"default")
            listInfoTcId?.add(x,"default")
        }

    }

    override fun initListener() {
        next.setOnClickListener {
            launchActivity<PaymentCashActivity> {  }
        }
        back.setOnClickListener {
            finish()
        }
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun nameInfo(text: String, position: Int) {
        listInfoName?.removeAt(position)
        listInfoName?.add(position, text)

     }

    override fun surnameInfo(text: String,position: Int) {
        listInfoSurname?.removeAt(position)
        listInfoSurname?.add(position, text)
    }

    override fun tcKimlikInfo(text: String,position: Int) {
        listInfoTcId?.removeAt(position)
        listInfoTcId?.add(position, text)
    }

}
