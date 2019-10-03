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
import farkvar.com.data.remote.network.RemoteDataException
import farkvar.com.data.remote.network.ResultWrapper
import farkvar.com.data.remote.service.buslist.IBusService
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class RemoteDataManager(
    private val busService: IBusService
) : IRemoteDataManager {
    override suspend fun satisIslemiAsync(id: String, request: SatisIslemiRequest): ResultWrapper<SatisIslemiResponse> =
        withContext(Dispatchers.IO) {
            resultWrapper(busService.satisIslemi(id, request))
        }

    override suspend fun satisIptalAsync(request: SatisİptaliRequest): ResultWrapper<SatisİptaliResponse> =
        withContext(Dispatchers.IO) {
            resultWrapper(busService.satisIptal(request))
        }

    override suspend fun otobusFirmalariListesiAsync(): ResultWrapper<OtobusFirmalariListesiResponse> =
        withContext(Dispatchers.IO) {
            resultWrapper(busService.otobusFirmalariListesi())
        }

    override suspend fun ulkelerListesiAsync(): ResultWrapper<UlkelerListesiResponse> =
        withContext(Dispatchers.IO) {
            resultWrapper(busService.ulkelerListesi())
        }

    override suspend fun binecegiYerSorgulamaAsync(id: String): ResultWrapper<BinecegiYerSorgulamaResponse> =
        withContext(Dispatchers.IO) {
            resultWrapper(busService.binecegiYerSorgulama(id))
        }

    override suspend fun servisBilgisiSorgulamaAsync(id: String): ResultWrapper<ServisBilgisiSorgulamaResponse> =
        withContext(Dispatchers.IO) {
            resultWrapper(busService.servisBilgisiSorgulama(id))
        }

    override suspend fun pnrAramaAsync(request: PnrAramaRequest): ResultWrapper<PnrAramaResponse> =
        withContext(Dispatchers.IO) {
            resultWrapper(busService.pnrArama(request))
        }


    override suspend fun karanoktalariAsync(): ResultWrapper<KaraNoktalariResponse> =
        withContext(Dispatchers.IO) {
            resultWrapper(busService.karaNoktalarıSorgulama())
        }

    override suspend fun seferListesiAsync(
        kalkisNoktaId: Int,
        varisNoktaId: Int,
        tarih: String,
        yolcuSayisi: Int
    ): ResultWrapper<SeferListesiResponse> =
        withContext(Dispatchers.IO) {
            resultWrapper(busService.seferListesiSorgulama(kalkisNoktaId, varisNoktaId, tarih, yolcuSayisi))
        }

    override suspend fun seferDetayiAsync(seferId: String): ResultWrapper<SeferDetayiSeferResponse> =
        withContext(Dispatchers.IO) {
            resultWrapper(busService.seferDetayiSorgulama(seferId))
        }

    override suspend fun koltukSatilabilirlikOnaylamaAsync(
        id: Int,
        request: KoltukSatilabilirlikOnaylamaRequest
    ): ResultWrapper<KoltukSatilabilirlikOnaylamaResponse> =
        withContext(Dispatchers.IO)
        {
            resultWrapper(busService.koltukSatilabilirlikOnaylama(id, request))
        }


    private suspend inline fun <reified T : Any> resultWrapper(request: Deferred<Response<T>>): ResultWrapper<T> {
        return try {
            val response = request.await()
            if (response.isSuccessful) {
                ResultWrapper.Success(response.body()!!)
            } else {
                ResultWrapper.Error(RemoteDataException(response.errorBody()))
            }
        } catch (ex: Throwable) {
            ResultWrapper.Error(RemoteDataException(ex))
        }
    }
}