package farkvar.com.data.repository

import farkvar.com.data.local.LocalDataManager
import farkvar.com.data.local.model.ConstantEntity
import farkvar.com.data.remote.RemoteDataManager
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

class DataManager(private val remoteDataManager: RemoteDataManager, private val localDataManager: LocalDataManager) :
    IDataManager {
    override suspend fun seferDetayiAsync(seferId: String): ResultWrapper<SeferDetayiSeferResponse> =
        remoteDataManager.seferDetayiAsync(seferId)

    override suspend fun koltukSatilabilirlikOnaylamaAsync(
        id: Int,
        request: KoltukSatilabilirlikOnaylamaRequest
    ): ResultWrapper<KoltukSatilabilirlikOnaylamaResponse> =
        remoteDataManager.koltukSatilabilirlikOnaylamaAsync(id, request)

    override suspend fun satisIslemiAsync(id: String, request: SatisIslemiRequest): ResultWrapper<SatisIslemiResponse> =
        remoteDataManager.satisIslemiAsync(id, request)

    override suspend fun satisIptalAsync(request: SatisİptaliRequest): ResultWrapper<SatisİptaliResponse> =
        remoteDataManager.satisIptalAsync(request)

    override suspend fun otobusFirmalariListesiAsync(): ResultWrapper<OtobusFirmalariListesiResponse> =
        remoteDataManager.otobusFirmalariListesiAsync()

    override suspend fun ulkelerListesiAsync(): ResultWrapper<UlkelerListesiResponse> =
        remoteDataManager.ulkelerListesiAsync()

    override suspend fun binecegiYerSorgulamaAsync(id: String): ResultWrapper<BinecegiYerSorgulamaResponse> =
        remoteDataManager.binecegiYerSorgulamaAsync(id)

    override suspend fun servisBilgisiSorgulamaAsync(id: String): ResultWrapper<ServisBilgisiSorgulamaResponse> =
        remoteDataManager.servisBilgisiSorgulamaAsync(id)

    override suspend fun pnrAramaAsync(request: PnrAramaRequest): ResultWrapper<PnrAramaResponse> =
        remoteDataManager.pnrAramaAsync(request)


    override suspend fun karanoktalariAsync(): ResultWrapper<KaraNoktalariResponse> =
        remoteDataManager.karanoktalariAsync()

    override suspend fun seferListesiAsync(
        kalkisNoktaId: Int,
        varisNoktaId: Int,
        tarih: String,
        yolcuSayisi: Int
    ): ResultWrapper<SeferListesiResponse> =
        remoteDataManager.seferListesiAsync(kalkisNoktaId, varisNoktaId, tarih, yolcuSayisi)


//    override suspend fun verifyForgotCode(request: VerifyPhoneRequest): ResultWrapper<VerifyPhoneResponse> =
//        remoteDataManager.verifyForgotCode(request)


    override fun insertConstant(constantEntity: ConstantEntity) = localDataManager.insertConstant(constantEntity)

    override fun deleteConstant() = localDataManager.deleteConstant()

    override fun getConstant(): ConstantEntity = localDataManager.getConstant()
}