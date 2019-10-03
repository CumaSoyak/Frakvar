package farkvar.com.data.remote

import farkvar.com.data.remote.model.buslist.binecegiyersorgulama.BinecegiYerSorgulamaResponse
import farkvar.com.data.remote.model.buslist.karanoktalari.KaraNoktalariResponse
import farkvar.com.data.remote.model.buslist.koltuksatilabilirlikonaylama.KoltukSatilabilirlikOnaylamaRequest
import farkvar.com.data.remote.model.buslist.koltuksatilabilirlikonaylama.KoltukSatilabilirlikOnaylamaResponse
import farkvar.com.data.remote.model.buslist.otobüsfirmalarilistesi.OtobusFirmalariListesiResponse
import farkvar.com.data.remote.model.buslist.pnrarama.PnrAramaRequest
import farkvar.com.data.remote.model.buslist.pnrarama.PnrAramaResponse
import farkvar.com.data.remote.model.buslist.satisIslemi.SatisIslemiRequest
import farkvar.com.data.remote.model.buslist.satisIslemi.SatisIslemiResponse
import farkvar.com.data.remote.model.buslist.satisiptali.SatisİptaliRequest
import farkvar.com.data.remote.model.buslist.satisiptali.SatisİptaliResponse
import farkvar.com.data.remote.model.buslist.seferdetayi.SeferDetayiSeferResponse
import farkvar.com.data.remote.model.buslist.seferlistesi.SeferListesiResponse
import farkvar.com.data.remote.model.buslist.servisbilgisisorgulama.ServisBilgisiSorgulamaResponse
import farkvar.com.data.remote.model.buslist.ulkelerlistesi.UlkelerListesiResponse
import farkvar.com.data.remote.network.ResultWrapper

interface IRemoteDataManager {
    suspend fun karanoktalariAsync(): ResultWrapper<KaraNoktalariResponse>

    suspend fun seferListesiAsync(
        kalkisNoktaId: Int,
        varisNoktaId: Int,
        tarih: String,
        yolcuSayisi: Int
    ): ResultWrapper<SeferListesiResponse>

    suspend fun seferDetayiAsync(seferId: String): ResultWrapper<SeferDetayiSeferResponse>

    suspend fun koltukSatilabilirlikOnaylamaAsync(id:Int,request: KoltukSatilabilirlikOnaylamaRequest):ResultWrapper<KoltukSatilabilirlikOnaylamaResponse>

    suspend fun satisIslemiAsync(id:String,request: SatisIslemiRequest):ResultWrapper<SatisIslemiResponse>

    suspend fun satisIptalAsync(request:SatisİptaliRequest):ResultWrapper<SatisİptaliResponse>

    suspend fun otobusFirmalariListesiAsync():ResultWrapper<OtobusFirmalariListesiResponse>

    suspend fun ulkelerListesiAsync():ResultWrapper<UlkelerListesiResponse>

    suspend fun binecegiYerSorgulamaAsync(id:String):ResultWrapper<BinecegiYerSorgulamaResponse>

    suspend fun servisBilgisiSorgulamaAsync(id:String):ResultWrapper<ServisBilgisiSorgulamaResponse>

    suspend fun pnrAramaAsync(request:PnrAramaRequest):ResultWrapper<PnrAramaResponse>


}