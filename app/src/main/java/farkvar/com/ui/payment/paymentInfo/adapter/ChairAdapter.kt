package farkvar.com.ui.payment.paymentInfo.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import farkvar.com.R
import farkvar.com.utils.extensions.inflate

class ChairAdapter(val chairList: ArrayList<String>) : RecyclerView.Adapter<ChairAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.item_chair))
    }

    override fun getItemCount(): Int =
        chairList.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (position == chairList.size) {
            holder.chair.text = getItem(position)
        } else {
            holder.chair.text = getItem(position)+"-"
        }
    }

    fun getItem(position: Int): String = chairList[position]

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val chair = itemView.findViewById(R.id.chair) as TextView
    }
}