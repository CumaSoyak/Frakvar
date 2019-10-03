package farkvar.com.utils.customscreen

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import farkvar.com.CoreApp.Companion.context
import farkvar.com.R

class Popup(context: Context) {

    companion object{
        var myDialog: Dialog? = null
        /** Bilgilendirme mesajları*/
        fun showPopupInfo(message: String) {
            myDialog = Dialog(context)
            //  myDialog?.setContentView(R.layout.custom_popup_info)
//          val btnFollow: AppCompatButton = myDialog!!.findViewById(R.id.btnPopupInfo) as AppCompatButton
//          val infoText: TextView = myDialog!!.findViewById(R.id.txtPopupInfo) as TextView
//          val close: ConstraintLayout = myDialog!!.findViewById(R.id.clInfoClose) as ConstraintLayout
//          infoText.setText(message)
//          if (message.equals(context.resources.getString(R.string.popup_appointment_cancel))) {
//              btnFollow.text = context.resources.getString(R.string.popup_agree)
////          }
//          btnFollow.setOnClickListener {
//              //todo eğer "ertleme talebi başarılı ise" ertelenirse veri tabanından succes dönünce göster
//              myDialog?.dismiss()
//          }
//
//          close.setOnClickListener {
//              myDialog?.dismiss()
//          }
            myDialog?.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            myDialog!!.show()
        }
    }


}