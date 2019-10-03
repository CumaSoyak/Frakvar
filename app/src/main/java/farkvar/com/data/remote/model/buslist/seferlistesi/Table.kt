package farkvar.com.data.remote.model.buslist.seferlistesi

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Table(
    @SerializedName("NormalBiletFiyati")
    @Expose
    val normalBiletFiyati: String? = "",
    @SerializedName("Saat")
    @Expose
    val saat: String? = "",
    @SerializedName("BiletFiyatiInternet")
    @Expose
    val biletFiyatiInternet: String = "",
    @SerializedName("YerelInternetSaat")
    @Expose
    val yerelInternetSaat: String = "",
    @SerializedName("VarisNoktaID")
    @Expose
    val varisNoktaID: String = "",
    @SerializedName("OtobusTipi")
    @Expose
    val otobusTipi: String = "",
    @SerializedName("YerelSaat")
    @Expose
    val yerelSaat: String = "",
    @SerializedName("MaximumRezerveTarihiSaati")
    @Expose
    val maximumRezerveTarihiSaati: String = "",
    @SerializedName("KalkisYeri")
    @Expose
    val kalkisYeri: String = "",
    @SerializedName("ID")
    @Expose
    val id: String = "",
    @SerializedName("MaxRzvZamani")
    @Expose
    val maxRzvZamani: String = "",
    @SerializedName("O_Tip_Sinif")
    @Expose
    val oTipSinif: String = "",
//    @SerializedName("Tesisler")
//    @Expose
//    val tesisler: String = "",
//    @SerializedName("YaklasikSeyahatSuresi")
//    @Expose
//    val yaklasikSeyahatSuresi: String = "",
    @SerializedName("OtobusTelefonu")
    @Expose
    val otobusTelefonu: String = "",
    @SerializedName("DolulukKuraliVar")
    @Expose
    val dolulukKuraliVar: String = "",
    @SerializedName("Tarih")
    @Expose
    val tarih: String = "",
    @SerializedName("ToplamSatisAdedi")
    @Expose
    val toplamSatisAdedi: String = "",
    @SerializedName("OTipOzellik")
    @Expose
    val oTipOzellik: String = "",
    @SerializedName("IlkKalkisNoktaID")
    @Expose
    val ilkKalkisNoktaID: String = "",
    @SerializedName("SeyahatSuresiGosterimTipi")
    @Expose
    val seyahatSuresiGosterimTipi: String = "",
    @SerializedName("GunBitimi")
    @Expose
    val gunBitimi: String = "",
    @SerializedName("HatNo")
    @Expose
    val hatNo: String = "",
    @SerializedName("Vakit")
    @Expose
    val vakit: String = "",
    @SerializedName("DoluSeferMi")
    @Expose
    val doluSeferMi: String = "",
    @SerializedName("Sinif_Farki")
    @Expose

    val sinifFarki: String = "",
    @SerializedName("SeferTakipNo")
    @Expose

    val seferTakipNo: String = "",
//    @SerializedName("KalkisTerminalAdi")
//    @Expose
//
//    val kalkisTerminalAdi: String = "",
    @SerializedName("VarisNokta")
    @Expose

    val varisNokta: String = "",
    @SerializedName("IlkKalkisNokta")
    @Expose

    val ilkKalkisNokta: String = "",
    @SerializedName("SonVarisNoktaID")
    @Expose

    val sonVarisNoktaID: String = "",
    @SerializedName("FirmaAdi")
    @Expose

    val firmaAdi: String = "",
    @SerializedName("VarisYeri")
    @Expose

    val varisYeri: String = "",
    @SerializedName("SeyahatSuresi")
    @Expose

    val seyahatSuresi: String = "",
    @SerializedName("KalkisNokta")
    @Expose

    val kalkisNokta: String = "",
    @SerializedName("KKZorunluMu")
    @Expose

    val kKZorunluMu: String = "",
    @SerializedName("BiletFiyati1")
    @Expose

    val biletFiyati: String = "",
    @SerializedName("SonVarisNokta")
    @Expose

    val sonVarisNokta: String = "",
    @SerializedName("SeferBosKoltukSayisi")
    @Expose

    val seferBosKoltukSayisi: String = "",
    @SerializedName("KalkisNoktaID")
    @Expose

    val kalkisNoktaID: String = "",
    @SerializedName("SonVarisYeri")
    @Expose

    val sonVarisYeri: String = "",
    @SerializedName("Guzergah")
    @Expose

    val guzergah: String = "",
    @SerializedName("IlkKalkisYeri")
    @Expose

    val ilkKalkisYeri: String = "",
    @SerializedName("OtobusKoltukYerlesimTipi")
    @Expose

    val otobusKoltukYerlesimTipi: String = "",
    @SerializedName("FirmaNo")
    @Expose

    val firmaNo: String = "",
    @SerializedName("SeferTipiAciklamasi")
    @Expose

    val seferTipiAciklamasi: String = ""
)