package farkvar.com.data.remote.model.buslist.seferlistesi

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import farkvar.com.data.remote.model.base.BaseResponse

class SeferListesiResponse(
    @SerializedName("Table")
    @Expose
    val table:ArrayList<Table>?=null,
    @SerializedName("OTipOzellik")
    @Expose
    val oTipOzellik:ArrayList<OTipOzellik>?=null

)