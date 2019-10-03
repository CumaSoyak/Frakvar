package farkvar.com.ui.air

 import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import farkvar.com.R

class AirAdapter(val airList: ArrayList<Air>) : RecyclerView.Adapter<AirAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AirAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_air_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return airList.size
    }

    override fun onBindViewHolder(holder: AirAdapter.ViewHolder, position: Int) {
        holder.bindItems(airList[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(air: Air) {
            val companyImage = itemView.findViewById(R.id.copmany_image) as ImageView
            val startAirport = itemView.findViewById(R.id.start_airport) as TextView
            val endAirport = itemView.findViewById(R.id.end_airport) as TextView
            val kilogram = itemView.findViewById(R.id.kilogram) as TextView
            val flightTransfer = itemView.findViewById(R.id.fight_transfer) as TextView
            val startTime = itemView.findViewById(R.id.start_time) as TextView
            val endTime = itemView.findViewById(R.id.end_time) as TextView
            val price = itemView.findViewById(R.id.price) as TextView

            startAirport.text = air.startAirport
            endAirport.text = air.endAirport
            kilogram.text = air.kilogram
            flightTransfer.text = air.flightTransfer
            startTime.text = air.startTime
            endTime.text = air.endTime
            price.text = air.price
        }
    }
}
