package farkvar.com.ui.air


import android.annotation.SuppressLint
import android.os.Bundle
 import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import farkvar.com.R


class AirListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_air_list, container, false)
        initView(view)
        setupRecylerView()
        return view
    }

    private fun initView(view: View) {
        recyclerView = view.findViewById(R.id.air_list_recylerview)//todo
    }

    @SuppressLint("WrongConstant")
    private fun setupRecylerView() {
        recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
        val airs = ArrayList<Air>()
        airs.add(Air(R.drawable.ic_flight_item, "Niğde", "Ankara", "50", "Direk", "15,15", "15:15", "58"))
        airs.add(Air(R.drawable.ic_flight_item, "Niğde", "Ankara", "50", "Aktarma", "15,15", "15:15", "49TL"))
        airs.add(Air(R.drawable.ic_flight_item, "Niğde", "Ankara", "50", "Direk", "15,15", "15:15", "49TL"))
        airs.add(Air(R.drawable.ic_flight_item, "Niğde", "Ankara", "50", "Direk", "15,15", "15:15", "49TL"))

        val adapter = AirAdapter(airs)
        recyclerView.adapter = adapter
    }


}
