package farkvar.com.data.remote.model.buslist.koltuksatilabilirlikonaylama

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class KoltukSatilabilirlikOnaylamaRequest(
    @SerializedName("seat[0][number]")
    @Expose
    val seatNumber0: Int?=null,

    @SerializedName("seat[0][gender]")
    @Expose
    val seatGender0: String?=null,

    @SerializedName("seat[1][number]")
    @Expose
    val seatNumber1: Int?=null,

    @SerializedName("seat[1][gender]")
    @Expose
    val seatGender1: String?=null
)