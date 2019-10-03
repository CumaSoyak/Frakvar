package farkvar.com.ui.bus.buslist.filtrele

import android.os.Bundle
import farkvar.com.R
import farkvar.com.ui.base.BaseDialogFragment
import kotlinx.android.synthetic.main.dialog_filtrele.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class FiltreleDialog : BaseDialogFragment(), IInfoNavigator {


    override val layoutId: Int
        get() = R.layout.dialog_filtrele

    private val viewModel by viewModel<InfoViewModel>()

    companion object {
        fun newInstance(contractId: Int): FiltreleDialog {
            return FiltreleDialog().apply {
                setStyle(STYLE_NORMAL, R.style.DialogFragmentTheme)
                arguments = Bundle().apply { putInt("contractId", contractId) }
            }
        }
    }


    override fun initNavigator() {
        viewModel.setNavigator(this)
    }

    override fun initUI() {
        observeViewModel()
    }

    private fun observeViewModel() {

    }

    override fun initListener() {

        ikiArtiBir.setOnClickListener {

        }
        ikiArtiİkiButon.setOnClickListener {

        }
        cancel.setOnClickListener {
            dialog.dismiss()
        }
    }

    override fun onSucces(message: String) {
    }
}