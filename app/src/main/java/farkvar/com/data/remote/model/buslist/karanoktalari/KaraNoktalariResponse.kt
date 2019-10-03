package farkvar.com.data.remote.model.buslist.karanoktalari

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import farkvar.com.data.remote.model.base.BaseResponse

class KaraNoktalariResponse(
    @SerializedName("KaraNokta")
    @Expose
    val karaNokta: ArrayList<KaraNoktalari>? = null
)