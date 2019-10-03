package farkvar.com.ui.payment.paymentForm.viewholder

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import farkvar.com.data.remote.model.userformmodel.UserFormModel
import kotlinx.android.synthetic.main.item_form.view.*
import java.text.FieldPosition

class UserFormViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(model: UserFormModel, position: Int,getInfo: GetInfo) = with(itemView) {

        name.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                getInfo.nameInfo(p0.toString(),position)
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
             }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

             }

        })
        surname.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
                getInfo.surnameInfo(p0.toString(),position)

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

        })
        tcNo.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
                getInfo.tcKimlikInfo(p0.toString(),position)

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

        })

        infoTitle.text =model.info


    }
}
interface GetInfo{
    fun nameInfo(text:String,position: Int)
    fun surnameInfo(text:String,position: Int)
    fun tcKimlikInfo(text:String,position: Int)
}