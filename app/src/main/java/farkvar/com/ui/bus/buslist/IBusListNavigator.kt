package farkvar.com.ui.bus.buslist

import farkvar.com.data.remote.model.buslist.seferdetayi.*
import farkvar.com.ui.base.IBaseNavigator

interface IBusListNavigator : IBaseNavigator {
    fun getSeferDetayiSucces(
        sefer: SeferDetayiSefer?,
        koltuk: ArrayList<SeferDetayiKoltuk>?,
        seyahatTipleri: ArrayList<SeferDetayiSeyehatTipleri>?,
        oTipOzellik: ArrayList<SeyahatDetayOTipOzellik>?,
        odemeKurallari: SeferDetayOdemeKurallari?
    )
}