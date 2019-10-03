package farkvar.com.data.remote.model.buslist.karanoktalari

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class KaraNoktalari(
    @SerializedName("ID")
    @Expose
    val ID: String? = null,

    @SerializedName("SeyahatSehirID")
    @Expose
    val SeyahatSehirID: String? = null,

    @SerializedName("Ad")
    @Expose
    val Ad: String? = null,

    @SerializedName("MerkezMi")
    @Expose
    val MerkezMi: String? = null,

    @SerializedName("BagliOlduguNoktaID")
    @Expose
    val BagliOlduguNoktaID: String? = null

)