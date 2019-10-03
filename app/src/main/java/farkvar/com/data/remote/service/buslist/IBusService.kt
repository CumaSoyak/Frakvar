package farkvar.com.data.remote.service.buslist

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
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.*

interface IBusService {
    @GET("bus/v1.0/stations")
    fun karaNoktalarıSorgulama(): Deferred<Response<KaraNoktalariResponse>>

    //bus/v1.0/trips?KalkisNoktaID=738&VarisNoktaID=84&Tarih=2019-09-02&YolcuSayisi=1
    //{{url}}/api/dietician?gender=&type=&sort=&latitude=40&longitude=40&full_name=&service_id&is_featured


    @GET("bus/v1.0/trips")
    fun seferListesiSorgulama(
        @Query("KalkisNoktaID") KalkisNoktaID: Int,
        @Query("VarisNoktaID") VarisNoktaID: Int,
        @Query("Tarih") Tarih: String,
        @Query("YolcuSayisi") YolcuSayisi: Int
    ): Deferred<Response<SeferListesiResponse>>

    @GET("bus/v1.0/trips/{seferId}")
    fun seferDetayiSorgulama(@Path("seferId") seferId: String): Deferred<Response<SeferDetayiSeferResponse>>

    @POST("bus/v1.0/trips/{id}/confirm")
    fun koltukSatilabilirlikOnaylama(@Path("id") id: Int, @Body request: KoltukSatilabilirlikOnaylamaRequest): Deferred<Response<KoltukSatilabilirlikOnaylamaResponse>>

    @POST("bus/v1.0/trips/{id}/purchase")
    fun satisIslemi(@Path("id") id: String, @Body request: SatisIslemiRequest): Deferred<Response<SatisIslemiResponse>>

    @POST("bus/v1.0/trips/cancel")
    fun satisIptal(@Body request: SatisİptaliRequest): Deferred<Response<SatisİptaliResponse>>

    @GET("bus/v1.0/companies")
    fun otobusFirmalariListesi(): Deferred<Response<OtobusFirmalariListesiResponse>>

    @GET("bus/v1.0/countries")
    fun ulkelerListesi(): Deferred<Response<UlkelerListesiResponse>>

    @GET("bus/v1.0/trips/{id}/boarding-stops")
    fun binecegiYerSorgulama(@Path("id") id: String): Deferred<Response<BinecegiYerSorgulamaResponse>>

    @GET("bus/v1.0/trips/{id}/services")
    fun servisBilgisiSorgulama(@Path("id") id: String):Deferred<Response<ServisBilgisiSorgulamaResponse>>

    @POST("bus/v1.0/pnr/search")
    fun pnrArama(@Body request:PnrAramaRequest):Deferred<Response<PnrAramaResponse>>
}