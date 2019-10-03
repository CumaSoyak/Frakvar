package farkvar.com.ui.payment.paymentForm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import farkvar.com.R
import farkvar.com.data.remote.model.userformmodel.UserFormModel
import farkvar.com.ui.payment.paymentForm.viewholder.GetInfo
import farkvar.com.ui.payment.paymentForm.viewholder.UserFormViewHolder
import farkvar.com.utils.extensions.inflate

class UserFromAdapter(var infoList: ArrayList<UserFormModel> = arrayListOf(),val getInfo: GetInfo) : RecyclerView.Adapter<UserFormViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserFormViewHolder =
        UserFormViewHolder(parent.inflate(R.layout.item_form))

    override fun getItemCount(): Int {
        return infoList.size
    }

    override fun onBindViewHolder(holder: UserFormViewHolder, position: Int) {
        holder.bind(infoList[position], position,getInfo)
    }

    fun add(list: ArrayList<UserFormModel>) {
        infoList.addAll(list)
        notifyDataSetChanged()

    }

}