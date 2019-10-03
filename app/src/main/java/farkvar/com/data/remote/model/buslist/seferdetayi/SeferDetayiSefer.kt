package farkvar.com.data.remote.model.buslist.seferdetayi

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SeferDetayiSefer(
    @SerializedName("Odeme3DSecureAktifMi")
    @Expose
    val odemeDSecureAktifMi: String = "",
    @SerializedName("GeceAciklamasi")
    @Expose
    val geceAciklamasi: String = "",
    @SerializedName("SubeSatistaTcKimlikNoYazmakZorunlu")
    @Expose
    val subeSatistaTcKimlikNoYazmakZorunlu: String = "",
    @SerializedName("BiletFiyatiInternet")
    @Expose
    val biletFiyatiInternet: String = "",
    @SerializedName("VarisNoktaID")
    @Expose
    val varisNoktaID: String = "",
    @SerializedName("FarkliFiyattaKoltuklarSecilebilirMi")
    @Expose
    val farkliFiyattaKoltuklarSecilebilirMi: String = "",
    @SerializedName("BiletFiyatiSinifFarki")
    @Expose
    val biletFiyatiSinifFarki: String = "",
    @SerializedName("VarisAdi")
    @Expose
    val varisAdi: String = "",
    @SerializedName("MaximumRezerveTarihiSaati")
    @Expose
    val maximumRezerveTarihiSaati: String = "",
    @SerializedName("OtobusTipSinif")
    @Expose
    val otobusTipSinif: String = "",
    @SerializedName("MaximumBosBayYaniSayisi")
    @Expose
    val maximumBosBayYaniSayisi: String = "",
    @SerializedName("Tesisler")
    @Expose
    val tesisler: String = "",
    @SerializedName("YaklasikSeyahatSuresi")
    @Expose
    val yaklasikSeyahatSuresi: String = "",
    @SerializedName("OTipOzellik")
    @Expose
    val oTipOzellik: String = "",
    @SerializedName("OtobusMesaj")
    @Expose
    val otobusMesaj: String = "",
    @SerializedName("OzurluIndirmliBiletSatar")
    @Expose

    val ozurluIndirmliBiletSatar: String = "",
    @SerializedName("Okalkti")
    @Expose
    val okalkti: String = "",
    @SerializedName("SeyahatSuresiGosterimTipi")
    @Expose
    val seyahatSuresiGosterimTipi: String = "",
    @SerializedName("HatNo")
    @Expose
    val hatNo: String = "",
    @SerializedName("PeronNo")
    @Expose
    val peronNo: String = "",
    @SerializedName("YolcuUyePuanToplam")
    @Expose
    val yolcuUyePuanToplam: String = "",
    @SerializedName("FirmaEnUygunFiyatAktifMi")
    @Expose
    val firmaEnUygunFiyatAktifMi: String = "",
    @SerializedName("YerelTarihSaat")
    @Expose
    val yerelTarihSaat: String = "",
    @SerializedName("FiyatDegistirebilir")
    @Expose
    val fiyatDegistirebilir: String = "",
    @SerializedName("Odeme3DSecureZorunluMu")
    @Expose
    val odemeDSecureZorunluMu: String = "",
    @SerializedName("FirmaMaxToplamBiletFiyati")
    @Expose
    val firmaMaxToplamBiletFiyati: String = "",
    @SerializedName("KalkisTerminalAdi")
    @Expose
    val kalkisTerminalAdi: String = "",
    @SerializedName("SatisAktifMi")
    @Expose
    val satisAktifMi: String = "",
    @SerializedName("VarisNokta")
    @Expose
    val varisNokta: String = "",
    @SerializedName("InternetTarihSaat")
    @Expose
    val internetTarihSaat: String = "",
    @SerializedName("KontenjanliBiletSatar")
    @Expose
    val kontenjanliBiletSatar: String = "",
    @SerializedName("RezervasyonAktifMi")
    @Expose
    val rezervasyonAktifMi: String = "",
    @SerializedName("KalkisAdi")
    @Expose
    val kalkisAdi: String = "",
    @SerializedName("PaypalUstLimit")
    @Expose
    val paypalUstLimit: String = "",
    @SerializedName("YolcuUyePuanCarpan")

    val yolcuUyePuanCarpan: String = "",
    @SerializedName("BiletFiyatiMisafir")
    @Expose
    val biletFiyatiMisafir: String = "",
    @SerializedName("SeyahatSuresi")
    @Expose
    val seyahatSuresi: String = "",
    @SerializedName("FarkliCinsiyetteKoltuklarSecilebilirMi")
    @Expose
    val farkliCinsiyetteKoltuklarSecilebilirMi: String = "",
    @SerializedName("MisafirBiletSatar")
    @Expose
    val misafirBiletSatar: String = "",
    @SerializedName("OtobusTip")
    @Expose
    val otobusTip: String = "",
    @SerializedName("MaximumBosBayanYaniSayisi")
    @Expose
    val maximumBosBayanYaniSayisi: String = "",
    @SerializedName("KalkisNokta")
    @Expose
    val kalkisNokta: String = "",
    @SerializedName("SubeBiletPort")
    @Expose
    val subeBiletPort: String = "",
    @SerializedName("PasaportNoIleIslemYapilirMi")
    @Expose
    val pasaportNoIleIslemYapilirMi: String = "",
    @SerializedName("BiletFiyati1")
    @Expose
    val biletFiyati1: String = "",
    @SerializedName("BiletFiyati3")
    @Expose
    val biletFiyati2: String = "",
    @SerializedName("BiletFiyati2")
    @Expose
    val biletFiyati3: String = "",
//    @SerializedName("OTipAciklamasi")
//    @Expose
//    val oTipAciklamasi: String = "",
    @SerializedName("DolulukOraniIndirimiYapildi")
    @Expose
    val dolulukOraniIndirimiYapildi: String = "",
    @SerializedName("KalkisNoktaID")
    @Expose
    val kalkisNoktaID: String = "",
    @SerializedName("OtobusTipIkinciKatSira")
    @Expose
    val otobusTipIkinciKatSira: String = "",
    @SerializedName("BiletTekKoltukFarki")
    @Expose
    val biletTekKoltukFarki: String = "",
    @SerializedName("SatilabilirKoltukSayi")
    @Expose
    val satilabilirKoltukSayi: String = "",
    @SerializedName("SeferTipiAciklamasi")
    @Expose
    val seferTipiAciklamasi: String = ""
)