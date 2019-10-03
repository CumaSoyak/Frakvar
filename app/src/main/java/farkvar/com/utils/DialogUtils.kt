package farkvar.com.utils

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import farkvar.com.R
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

object DialogUtils {

    var dateValue: String? = ""
    var hoursValue: String? = ""
    private var myDialog: Dialog? = null

    data class DialogModel(

        var title: String? = null,

        var message: String? = null,

        var uniqueId: Int = 0,

        var positive: String? = null,

        var negative: String? = null,

        @DrawableRes

        var icon: Int = 0,

        var isNegativeButton: Boolean = false

    )


    interface DialogAlertListener {

        fun onPositiveClick()

        fun onNegativeClick()

    }


    fun showAlertDialog(

        context: Context,

        dialogModel: DialogModel,

        listener: DialogAlertListener? = null

    ) {

        val dialog = AlertDialog.Builder(context)

        val layoutInflater = LayoutInflater.from(context)

        val dialogView = layoutInflater.inflate(R.layout.custom_popup_error, null)

        val icon = dialogView.findViewById<ConstraintLayout>(R.id.clPopup)

        val message = dialogView.findViewById<TextView>(R.id.txtPopupInfo)

        val btnOk = dialogView.findViewById<ConstraintLayout>(R.id.clPopup)

        val btnPositive = dialogView.findViewById<Button>(R.id.btnPopupInfo)

        //val btnNegative = dialogView.findViewById<AppCompatButton>(R.id.btnNegativeDialog)

        //val lnNegative = dialogView.findViewById<LinearLayout>(R.id.lnNegative)

        dialog.setView(dialogView)


        //icon.setImageDrawable(ContextCompat.getDrawable(context, dialogModel.icon))

        message.text = dialogModel.message





        if (dialogModel.isNegativeButton) {

            //lnNegative.visibility = View.VISIBLE

            btnOk.visibility = View.GONE

            btnPositive.text = dialogModel.positive

            //btnNegative.text = dialogModel.negative

        } else {

            //lnNegative.visibility = View.GONE

            btnOk.visibility = View.VISIBLE

            // btnOk.text = dialogModel.positive

        }


        val alertDialog = dialog.create()

        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)

        alertDialog.setCanceledOnTouchOutside(false)

        val v = alertDialog.window.decorView

        v.setBackgroundResource(android.R.color.transparent)

        alertDialog.show()



        btnOk.setOnClickListener {

            listener?.onPositiveClick()

            alertDialog.cancel()

        }



        btnPositive.setOnClickListener {

            listener?.onPositiveClick()

            alertDialog.cancel()

        }


/*
        btnNegative.setOnClickListener {

            listener?.onNegativeClick()

            alertDialog.cancel()

        }*/


    }
//
//    fun showAlertConfirmationDialog(
//
//        context: Context,
//
//        dialogModel: DialogModel,
//
//        listener: DialogAlertListener? = null
//
//    ) {
//
//        val dialog = AlertDialog.Builder(context)
//
//        val layoutInflater = LayoutInflater.from(context)
//
//        val dialogView = layoutInflater.inflate(R.layout.custom_popup_login_register, null)
//
//        val icon = dialogView.findViewById<ImageView>(R.id.imgPopupError)
//
//        val message = dialogView.findViewById<TextView>(R.id.txtPopupSucsess)
//
//        val btnNegative = dialogView.findViewById<AppCompatButton>(R.id.btnDecline)
//
//        val btnPositive = dialogView.findViewById<AppCompatButton>(R.id.btnAccept)
//
//        val cancelButton = dialogView.findViewById<ConstraintLayout>(R.id.clSuccessClose)
//
//
//
//
//        dialog.setView(dialogView)
//
//        icon.setImageDrawable(ContextCompat.getDrawable(context, dialogModel.icon))
//
//
//        message.text = dialogModel.message
//
//
//        btnPositive.text = dialogModel.positive
//
//        btnNegative.text = dialogModel.negative
//
//
//        if (dialogModel.isNegativeButton) {
//
//
//            btnNegative.visibility = View.VISIBLE
//            btnPositive.visibility = View.VISIBLE
//
//
//        } else {
//
//
//            btnNegative.visibility = View.GONE
//
//
//        }
//
//
//        val alertDialog = dialog.create()
//
//        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
//
//        alertDialog.setCanceledOnTouchOutside(false)
//
//        val v = alertDialog.window.decorView
//
//        v.setBackgroundResource(android.R.color.transparent)
//
//        alertDialog.show()
//
//
//
//        btnNegative.setOnClickListener {
//
//            listener?.onNegativeClick()
//
//            alertDialog.cancel()
//
//        }
//
//
//
//        btnPositive.setOnClickListener {
//
//            listener?.onPositiveClick()
//
//            alertDialog.cancel()
//
//        }
//
//
//        cancelButton.setOnClickListener {
//            alertDialog.dismiss()
//        }
//
//
//    }

//    fun checkLoginControl(context: Context) {
//
//        val dialog = AlertDialog.Builder(context)
//
//        val layoutInflater = LayoutInflater.from(context)
//
//        val dialogView = layoutInflater.inflate(R.layout.custom_popup_login_register, null)
//
//        val icon = dialogView.findViewById<ImageView>(R.id.imgPopupError)
//
//        val message = dialogView.findViewById<TextView>(R.id.txtPopupSucsess)
//
//        val btnNegative = dialogView.findViewById<AppCompatButton>(R.id.btnDecline)
//
//        val btnPositive = dialogView.findViewById<AppCompatButton>(R.id.btnAccept)
//
//        val cancelButton = dialogView.findViewById<ConstraintLayout>(R.id.clSuccessClose)
//
//
//        message.setText(R.string.popu_login_register)
//
//        icon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_info))
//
//        dialog.setView(dialogView)
//
//        val alertDialog = dialog.create()
//
//        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
//
//        alertDialog.setCanceledOnTouchOutside(false)
//
//        val v = alertDialog.window.decorView
//
//        v.setBackgroundResource(android.R.color.transparent)
//
//        alertDialog.show()
//
//
//
//        btnNegative.setOnClickListener {
//            alertDialog.cancel()
//            alertDialog.dismiss()
//
//        }
//
//        cancelButton.setOnClickListener {
//            alertDialog.dismiss()
//        }
//
//
//        btnPositive.setOnClickListener {
//            alertDialog.cancel()
//            context.launchActivity<AuthLoginActivity> { }
//
//
//        }
//
//
//    }
//
//    fun showPopupBigPhoto(
//        context: Context,
//        position: Int,
//        photoList: ArrayList<String>,
//        adapterBigPhoto: BigPhotoAdapter
//    ) {
//        var myDialog: Dialog? = null
//        myDialog = Dialog(context)
//        myDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        myDialog?.setContentView(R.layout.custom_popup_big_photo)
//        val window = myDialog.window
//        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
//        myDialog.setCanceledOnTouchOutside(true)
//        var index: Int = position
//
//        val recyclerView: RecyclerView = myDialog!!.findViewById(R.id.rv_big_photo) as RecyclerView
//        val close: ImageView = myDialog!!.findViewById(R.id.close) as ImageView
//
//        recyclerView.adapter = adapterBigPhoto
//        recyclerView.smoothSnapToPosition(position)
//        adapterBigPhoto.add(photoList)
//
//        close.setOnClickListener {
//            myDialog.dismiss()
//        }
//
//        myDialog?.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//        myDialog!!.show()
//    }

    /**Tarih işlemleri*/
    fun openDate(context: Context, textView: TextView) {
        val c = Calendar.getInstance()
        val day = c.get(Calendar.DAY_OF_MONTH)
        val month = c.get(Calendar.MONTH)
        val year = c.get(Calendar.YEAR)

        val dpd = DatePickerDialog(
            context,
            android.R.style.Theme_Holo_Light_Dialog_MinWidth,
            DatePickerDialog.OnDateSetListener { datePicker, year, monthOfYear, dayOfMonth ->
                var day: Int = dayOfMonth
                var month: Int = (monthOfYear + 1)
                var monthString: String = month.toString()
                var dayString: String = day.toString()

                if (month < 10) {
                    monthString = "0" + month.toString()
                }
                if (dayOfMonth < 10) {
                    dayString = "0" + day.toString()
                }
                textView.text = dayString + "." + monthString + "." + "$year"
                setDate("$year-$monthString-$dayString")

                textView.setTextColor(context.resources.getColor(R.color.colorTextColor))

            },
            year,
            month,
            day
        )

        dpd.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dpd.show()

    }

    fun setDate(birth: String) {
        this.dateValue = birth
    }

    fun getDate(): String? {
        return dateValue
    }

    fun openHours(context: Context, textView: TextView) {
        val cal = Calendar.getInstance()
        val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
            cal.set(Calendar.HOUR_OF_DAY, hour)
            cal.set(Calendar.MINUTE, minute)
            textView.text = SimpleDateFormat("HH:mm").format(cal.time)
            setHours(SimpleDateFormat("HH:mm").format(cal.time))
        }
        TimePickerDialog(context, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()
    }

    fun getHours(): String? {
        return hoursValue
    }

    fun setHours(time: String) {
        this.hoursValue = time
    }

    /** Bilgilendirme popuları*/


    fun showError2(context: Context,errorMessage: String) {
        val model = DialogUtils.DialogModel(
            "",
            errorMessage,
            0,
            "Tamam",
            "",
            R.drawable.ic_bus_melon,
            false
        )

        DialogUtils.showAlertDialog(context, model, object : DialogUtils.DialogAlertListener {

            override fun onPositiveClick() {

            }

            override fun onNegativeClick() {

            }

        })
    }

//    /** Bilgilendirme mesajları*/
//    fun showPopupInfo(context: Context,message: String) {
//        myDialog = Dialog(context)
//        myDialog?.setContentView(R.layout.custom_popup_info)
//        val btnFollow: AppCompatButton = myDialog!!.findViewById(R.id.btnPopupInfo) as AppCompatButton
//        val infoText: TextView = myDialog!!.findViewById(R.id.txtPopupInfo) as TextView
//        val close: ConstraintLayout = myDialog!!.findViewById(R.id.clInfoClose) as ConstraintLayout
//        infoText.setText(message)
//        if (message.equals(context.resources.getString(R.string.popup_appointment_cancel))) {
//            btnFollow.text =context. resources.getString(R.string.popup_agree)
//        }
//        btnFollow.setOnClickListener {
//            //todo eğer "ertleme talebi başarılı ise" ertelenirse veri tabanından succes dönünce göster
//            myDialog?.dismiss()
//        }
//
//        close.setOnClickListener {
//            myDialog?.dismiss()
//        }
//        myDialog?.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//        myDialog!!.show()
//    }

    /**Error mesajları*/
    fun showPopupError(context: Context,message: String) {

        showError2(context,message)

    }

    /**Başarılı mesajlar*/
    fun showPopupSuccess(context: Context,message: String) {
        var myDialog= Dialog(context)
        myDialog?.setContentView( R.layout.custom_popup_success)
        val btnFollow: AppCompatButton = myDialog!!.findViewById( R.id.btnPopupSuccess) as AppCompatButton
        val txtPopup: TextView = myDialog!!.findViewById( R.id.txtPopupSucsess) as TextView
        val close: ConstraintLayout = myDialog!!.findViewById(R.id.clSuccessClose) as ConstraintLayout

        txtPopup.text = message

        btnFollow.setOnClickListener {
            myDialog?.dismiss()

        }

        close.setOnClickListener {
            myDialog?.dismiss()
        }

        myDialog?.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        myDialog!!.show()
    }
    @SuppressLint("WrongViewCast")
    fun showPopupNotification(context: Context, message: String) {
        myDialog = Dialog(context)
        myDialog?.setContentView( R.layout.custom_popup_notification)
         val txtPopup: RecyclerView = myDialog!!.findViewById( R.id.rvNotication) as RecyclerView
       // val close: ConstraintLayout = myDialog!!.findViewById(R.id.clSuccessClose) as ConstraintLayout

//
//        btnFollow.setOnClickListener {
//            myDialog?.dismiss()
//
//        }
//
//        close.setOnClickListener {
//            myDialog?.dismiss()
//        }

        myDialog?.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        myDialog!!.show()
    }

}

