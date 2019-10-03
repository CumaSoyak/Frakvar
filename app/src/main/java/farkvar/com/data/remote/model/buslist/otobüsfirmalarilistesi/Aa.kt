package farkvar.com.data.remote.model.buslist.otobüsfirmalarilistesi

import com.google.gson.annotations.SerializedName

data class Aa(
    @SerializedName("AcikParaKullanimAktifMi")
    val acikParaKullanimAktifMi: String = "",
    @SerializedName("BosKullaniciKodu")
    val bosKullaniciKodu: String = "",
    @SerializedName("SefereKadarIptalEdilebilmeSuresiDakika")
    val sefereKadarIptalEdilebilmeSuresiDakika: String = "",
    @SerializedName("BiletIptalAktifMi")
    val biletIptalAktifMi: String = "",
    @SerializedName("FirmaOtobusteMaxAyniUyeKartliIslemSayisi")
    val firmaOtobusteMaxAyniUyeKartliIslemSayisi: String = "",
    @SerializedName("Firma_No")
    val firmaNo: String = "",
    @SerializedName("Bilet_Seri_No_Takip")
    val biletSeriNoTakip: String = "",
    @SerializedName("Bilet_Seri_No")
    val biletSeriNo: String = "",
    @SerializedName("BosSubeKodu")
    val bosSubeKodu: String = "",
    @SerializedName("Firmaadi")
    val firmaadi: String = "",
    @SerializedName("FirmaNoStr")
    val firmaNoStr: String = "",
    @SerializedName("Sat_Koltuk_Adet")
    val satKoltukAdet: String = "",
    @SerializedName("Rez_Koltuk_Adet")
    val rezKoltukAdet: String = "",
    @SerializedName("WebAdresi")
    val webAdresi: String = "",
    @SerializedName("FirmaLogo")
    val firmaLogo: String = "",
    @SerializedName("Telefon")
    val telefon: String = "",
    @SerializedName("FirmaCokluCinsiyetIslemYapabilir")
    val firmaCokluCinsiyetIslemYapabilir: String = ""
)