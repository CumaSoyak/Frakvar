package farkvar.com.ui.bus.buslist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import farkvar.com.R
import farkvar.com.data.remote.model.buslist.seferlistesi.Table

class BusAdapter(val busListListModel: ArrayList<Table>, val ticketListener: TicketListener) :
    RecyclerView.Adapter<BusAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_bus_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return busListListModel.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = busListListModel[position]
        holder.companyImage.setImageResource(R.drawable.ic_bus_melon)
        holder.startStation.text = model.ilkKalkisYeri+" > "+model.sonVarisYeri
        holder.startTime.text = model.saat?.substring(11,16)
        holder.price.text = model.biletFiyatiInternet+" TL"
        holder.option.text=model.otobusKoltukYerlesimTipi
        holder.totalTime.text="5-5"     //model.yaklasikSeyahatSuresi
        holder.chooseButton.setOnClickListener {
            ticketListener.onClickListener(model)
        }
     }

    fun add(listModel: ArrayList<Table>) {
        busListListModel.clear()
        busListListModel.addAll(listModel)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val companyImage = itemView.findViewById(R.id.copmany_image) as ImageView
        val startStation = itemView.findViewById(R.id.start_station) as TextView
        val startTime = itemView.findViewById(R.id.start_time) as TextView
        val price = itemView.findViewById(R.id.price) as TextView
        val chooseButton = itemView.findViewById(R.id.choose_button) as TextView
        val option = itemView.findViewById(R.id.chair_option) as TextView
        val totalTime = itemView.findViewById(R.id.total_time) as TextView


    }

}

interface TicketListener {
    fun onClickListener(model:Table)
}