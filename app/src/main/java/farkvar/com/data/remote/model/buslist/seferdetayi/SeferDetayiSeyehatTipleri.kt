package farkvar.com.data.remote.model.buslist.seferdetayi

import com.google.gson.annotations.SerializedName

data class SeferDetayiSeyehatTipleri(@SerializedName("BiletFiyati")
                                     val biletFiyati: String = "",
                                     @SerializedName("BiletFiyatSinifFarki")
                                     val biletFiyatSinifFarki: String = "",
                                     @SerializedName("BiletTekKoltukFarki")
                                     val biletTekKoltukFarki: String = "",
                                     @SerializedName("SeyahatAdi")
                                     val seyahatAdi: String = "",
                                     @SerializedName("SeyahatTipi")
                                     val seyahatTipi: String = "")