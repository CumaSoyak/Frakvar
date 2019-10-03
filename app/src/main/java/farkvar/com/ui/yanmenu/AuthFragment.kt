package farkvar.com.ui.yanmenu

import android.os.Bundle
import androidx.core.view.isGone
import androidx.core.view.isVisible
import farkvar.com.R
import farkvar.com.ui.base.BaseDialogFragment
import farkvar.com.ui.bus.buslist.filtrele.IInfoNavigator
import farkvar.com.ui.bus.buslist.filtrele.InfoViewModel
import farkvar.com.utils.extensions.applyWindowInsets
import farkvar.com.utils.extensions.gone
import kotlinx.android.synthetic.main.fragment_auth.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class AuthFragment : BaseDialogFragment(), IInfoNavigator {


    override val layoutId: Int
        get() = R.layout.fragment_auth
    private val viewModel by viewModel<InfoViewModel>()

    companion object {
        fun newInstance(contractId: Int): AuthFragment {
            return AuthFragment().apply {
                setStyle(STYLE_NORMAL, R.style.DialogFragmentTheme)
                arguments = Bundle().apply { putInt("contractId", contractId) }
            }
        }
    }

    override fun initNavigator() {
        viewModel.setNavigator(this)
    }

    override fun initUI() {
    }

    override fun initListener() {
        uyeol.setOnClickListener {
            textView15.applyWindowInsets()
        }
    }

}