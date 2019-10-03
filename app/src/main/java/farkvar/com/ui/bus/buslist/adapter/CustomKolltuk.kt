package farkvar.com.ui.bus.buslist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import farkvar.com.R
import farkvar.com.data.remote.model.buslist.seferdetayi.SeferDetayiKoltuk


class CustomKolltuk(val chairList: ArrayList<SeferDetayiKoltuk>,val BusKoltukListener: BusKoltukListener) :
    RecyclerView.Adapter<CustomKolltuk.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chair, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return chairList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = chairList[position]
        // holder.koltukImage
        holder.bind(model)

//        if (mod(position,4)!=2)
//        {
//            val layoutParams = holder.conteiner.getLayoutParams() as ViewGroup.MarginLayoutParams
//            layoutParams.setMargins(2, 2,2, 2)
//            holder.conteiner.requestLayout()
//        }

        holder.itemView.setOnClickListener {
            BusKoltukListener.satisOnay(1,"",2,"")
        }
    }

    fun add(listModel: ArrayList<SeferDetayiKoltuk>) {
        chairList.clear()
        chairList.addAll(listModel)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val koltukImage = itemView.findViewById(R.id.chairImage) as ImageView
        var koltukNo = itemView.findViewById(R.id.koltukNo) as TextView
        var conteiner = itemView.findViewById(R.id.container) as CardView
        fun bind(model: SeferDetayiKoltuk) {
            koltukNo.text = model.koltukNo
            if (model.koltukStr.equals("KO")) {
                conteiner.visibility = View.INVISIBLE
            }
        }
    }

}
interface BusKoltukListener{
    fun satisOnay(number1:Int,gender1:String,number2:Int,gender2:String)
}

