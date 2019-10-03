package farkvar.com.ui.payment.paymentcash

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import androidx.annotation.RequiresApi
import farkvar.com.R
import farkvar.com.ui.base.BaseActivity
import farkvar.com.utils.extensions.launchActivity
import kotlinx.android.synthetic.main.activity_payment_cash.*
import kotlinx.android.synthetic.main.page_toolbar.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class PaymentCashActivity : BaseActivity() {
    override val layoutId: Int?
        get() = R.layout.activity_payment_cash

    private val viewModel by viewModel<PaymentCashViewModel>()

    override fun initNavigator() {
        viewModel.setNavigator(this)
    }

    override fun initUI() {
    }

    override fun initListener() {
         setContract()
        back.setOnClickListener {
            finish()
        }
    }

    private fun setContract() {

        val ss = SpannableString("Kullanım Koşulları'nı ve gizlilik sözleşmesi'ni okudum kabul ediyorum.")
        val clickableSpan = object : ClickableSpan() {
            override fun onClick(textView: View) {

             //   launchActivity<AuthContractActivity> { }
             }

            @RequiresApi(Build.VERSION_CODES.M)
            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = true
                ds.color = resources.getColor(R.color.colorTextColor)
                ds.isFakeBoldText = true
            }
        }
        val clickableSpan1 = object : ClickableSpan() {
            override fun onClick(widget: View) {

//                launchActivity<AuthContractActivity> {
//                 }
             }

            @RequiresApi(Build.VERSION_CODES.M)
            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = true
                ds.color = resources.getColor(R.color.colorTextColor)
                ds.isFakeBoldText = true
            }

        }
        ss.setSpan(clickableSpan, 0, 18, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        ss.setSpan(clickableSpan1, 25, 44, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        kosul.text = ss
        kosul.movementMethod = LinkMovementMethod.getInstance()
        //tvAgreement.highlightColor = Color.TRANSPARENT
        kosul.setTextColor(resources.getColor(R.color.colorTextColor))
    }



}
