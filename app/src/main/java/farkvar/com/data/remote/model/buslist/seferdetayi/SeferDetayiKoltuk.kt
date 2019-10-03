package farkvar.com.data.remote.model.buslist.seferdetayi

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

 class SeferDetayiKoltuk(
    @SerializedName("KoltukFiyatiInternet")
    @Expose
    val koltukFiyatiInternet: String = "",
    @SerializedName("KoltukNo")
    @Expose
    val koltukNo: String = "",
    @SerializedName("DurumYan")
    @Expose
    val durumYan: String = "",
    @SerializedName("KoltukStr")
    @Expose
    val koltukStr: String = "",
    @SerializedName("Durum")
    @Expose
    val durum: String = ""
)