package farkvar.com.ui.search.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
 import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import farkvar.com.R
import farkvar.com.data.remote.model.buslist.karanoktalari.KaraNoktalari


class SearchAdapter(var busListListModel: ArrayList<KaraNoktalari>, val karaNoktaListener: IKaraNoktaInterface) :
    RecyclerView.Adapter<SearchAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_search, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return busListListModel.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = busListListModel[position]
        holder.sehir.text = model.Ad
        holder.itemView.setOnClickListener {
            karaNoktaListener.karaNoktaClick(model)
        }
    }

    fun add(listModel: ArrayList<KaraNoktalari>) {
        busListListModel.addAll(listModel)
        notifyDataSetChanged()
    }
    fun filterList(filteredDieticianList: ArrayList<KaraNoktalari>) {
        this.busListListModel = filteredDieticianList
        notifyDataSetChanged()
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
      val sehir = itemView.findViewById(R.id.sehir) as TextView


    }

}

interface IKaraNoktaInterface {
    fun karaNoktaClick(model: KaraNoktalari)
}