package farkvar.com.data.remote.model.buslist.pnrarama

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PnrAramaRequest(
    @SerializedName("pnr")
    @Expose
    val pnr: String? = null,

    @SerializedName("phoneOrSurname")
    @Expose
    val phoneOrSurname: String? = null
)