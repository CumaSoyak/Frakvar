package farkvar.com.data.remote.model.base

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

open class BaseResponse<out T>(
//    @SerializedName("code")
//    @Expose
//    val code: String = "",
//    @SerializedName("Hata")
//    @Expose
//    val message: String = "",
//
//
//    /**Kara Noktaları sorgulama*/
//
//    @SerializedName("KaraNokta")
//    @Expose
//    val kara: ArrayList<Any>? = null,

//
//    @SerializedName("Table")
//    @Expose
//    val table: T? = null,

    @SerializedName("Table")
    @Expose
    val tablea: ArrayList<Any>? = null

//
//    /**Sefer Listesi sorgulama*/
//
////    @SerializedName("Table")
////    @Expose
////    val table: ArrayList<Any>? = null,
//
//    @SerializedName("OTipOzellik")
//    @Expose
//    val OTipOzellik: ArrayList<Any>? = null,

//    /**Sefer detayı Sorgulama*/
//
////    @SerializedName("Sefer")
////    @Expose
////    val sefer: T? = null,
//
//    @SerializedName("Koltuk")
//    @Expose
//    val koltuk: ArrayList<Any>? = null,
//
//    @SerializedName("SeyahatTipleri")
//    @Expose
//    val seyahatTipleri: ArrayList<Any>? = null,
//
//    @SerializedName("OTipOzellik")
//    @Expose
//    val oTipOzellikSeferDetayi: ArrayList<Any>? = null


)