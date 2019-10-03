package farkvar.com.data.remote.model.buslist.seferdetayi

import com.google.gson.annotations.SerializedName

data class SeyahatDetayOTipOzellik(@SerializedName("O_Tip_Ozellik_Detay")
                                   val oTipOzellikDetay: String = "",
                                   @SerializedName("O_Tip_Ozellik_Icon")
                                   val oTipOzellikIcon: String = "",
                                   @SerializedName("O_Tip_Ozellik")
                                   val oTipOzellik: String = "",
                                   @SerializedName("O_Tip_Ozellik_Aciklama")
                                   val oTipOzellikAciklama: String = "")