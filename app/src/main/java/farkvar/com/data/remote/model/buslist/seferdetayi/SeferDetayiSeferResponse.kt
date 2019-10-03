package farkvar.com.data.remote.model.buslist.seferdetayi

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import farkvar.com.data.remote.model.base.BaseResponse

class SeferDetayiSeferResponse(
    @SerializedName("Sefer")
    @Expose
    val sefer: SeferDetayiSefer? = null,

    @SerializedName("Koltuk")
    @Expose
    val koltuk: ArrayList<SeferDetayiKoltuk>? = null,

    @SerializedName("SeyahatTipleri")
    @Expose
    val seyahatTipleri: ArrayList<SeferDetayiSeyehatTipleri>? = null,


    @SerializedName("OTipOzellik")
    @Expose
    val oTipOzellik: ArrayList<SeyahatDetayOTipOzellik>? = null,


    @SerializedName("OdemeKurallari")
    @Expose
    val odemeKurallari:SeferDetayOdemeKurallari? = null

)