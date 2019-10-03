package farkvar.com.data.remote.model.buslist.otobüsfirmalarilistesi

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import farkvar.com.data.remote.model.base.BaseResponse
import farkvar.com.data.remote.model.buslist.seferlistesi.OTipOzellik

class  OtobusFirmalariListesiResponse(
    @SerializedName("Table")
    @Expose
    val Table: ArrayList<OtobusFirmalariListesi>? = null,
    @SerializedName("OTipOzellik")
    @Expose
    val OTipOzellik: ArrayList<OtobusFirmalariListesi>? = null
)