package farkvar.com.data.remote.model.buslist.seferdetayi

import com.google.gson.annotations.SerializedName

data class SeferDetayOdemeKurallari(
    @SerializedName("MasterpassAktifMi")
    val masterpassAktifMi: String = "",
    @SerializedName("PaypalOdemeAktifMi")
    val paypalOdemeAktifMi: String = "",
    @SerializedName("OnOdemeAktifMi")
    val onOdemeAktifMi: String = "",
    @SerializedName("Odeme3DSecureAktifMi")
    val odemeDSecureAktifMi: String = "",
    @SerializedName("ParakodOdemeAktifMi")
    val parakodOdemeAktifMi: String = "",
    @SerializedName("AcikParaliOdemeAktifMi")
    val acikParaliOdemeAktifMi: String = "",
    @SerializedName("BkmOdemeAktifMi")
    val bkmOdemeAktifMi: String = "",
    @SerializedName("HopiAktifMi")
    val hopiAktifMi: String = "",
    @SerializedName("PaypalUstLimit")
    val paypalUstLimit: String = "",
    @SerializedName("Odeme3DSecureZorunluMu")
    val odemeDSecureZorunluMu: String = "",
    @SerializedName("FastPayOdemeAktifMi")
    val fastPayOdemeAktifMi: String = ""
)