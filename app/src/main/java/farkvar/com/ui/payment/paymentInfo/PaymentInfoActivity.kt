package farkvar.com.ui.payment.paymentInfo

import farkvar.com.R
import farkvar.com.ui.base.BaseActivity
import farkvar.com.ui.payment.paymentForm.PaymentFormActivity
import farkvar.com.utils.extensions.launchActivity
import kotlinx.android.synthetic.main.activity_payment_info.*
import kotlinx.android.synthetic.main.page_toolbar.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class PaymentInfoActivity : BaseActivity() {

    override val layoutId: Int?
        get() = R.layout.activity_payment_info

    private val viewModel by viewModel<PaymentInfoViewModel>()

    override fun initNavigator() {
        viewModel.setNavigator(this)
    }

    override fun initUI() {
        initData()
    }

    private fun initData() {
        customer_count.text = "1"
        //company_image.load("")
        time.text=""
        date.text=""
        start_station.text=""
        end_time.text=""
        end_date.text=""
        endStation.text=""
        date_sub.text=""
        seat_status.text=""
    }

    override fun initListener() {
        next.setOnClickListener { launchActivity<PaymentFormActivity> { } }
        back.setOnClickListener {
            finish()
        }
    }


}
