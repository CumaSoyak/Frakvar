package farkvar.com.data.remote.model.buslist.otobüsfirmalarilistesi

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class OtobusFirmalariListesi (
    @SerializedName("AcikParaKullanimAktifMi")
    @Expose
    val acikParaKullanimAktifMi: String ?= null,
    @SerializedName("BosKullaniciKodu")
    @Expose
    val bosKullaniciKodu: String = "",
    @SerializedName("SefereKadarIptalEdilebilmeSuresiDakika")
    @Expose
    val sefereKadarIptalEdilebilmeSuresiDakika: String = "",
    @SerializedName("BiletIptalAktifMi")
    @Expose
    val biletIptalAktifMi: String = "",
    @SerializedName("FirmaOtobusteMaxAyniUyeKartliIslemSayisi")
    @Expose
    val firmaOtobusteMaxAyniUyeKartliIslemSayisi: String = "",
    @SerializedName("Firma_No")
    @Expose
    val firmaNo: String = "",
    @SerializedName("Bilet_Seri_No_Takip")
    @Expose
    val biletSeriNoTakip: String = "",
    @SerializedName("Bilet_Seri_No")
    @Expose
    val biletSeriNo: String = "",
    @SerializedName("BosSubeKodu")
    @Expose
    val bosSubeKodu: String = "",
    @SerializedName("Firmaadi")
    @Expose
    val firmaadi: String = "",
    @SerializedName("FirmaNoStr")
    @Expose
    val firmaNoStr: String = "",
    @SerializedName("Sat_Koltuk_Adet")
    @Expose
    val satKoltukAdet: String = "",
    @SerializedName("Rez_Koltuk_Adet")
    @Expose
    val rezKoltukAdet: String = "",
    @SerializedName("WebAdresi")
    @Expose
    val webAdresi: String = "",
    @SerializedName("FirmaLogo")
    @Expose
    val firmaLogo: String = "",
    @SerializedName("Telefon")
    @Expose
    val telefon: String = "",
    @SerializedName("FirmaCokluCinsiyetIslemYapabilir")
    @Expose
    val firmaCokluCinsiyetIslemYapabilir: String = ""
)