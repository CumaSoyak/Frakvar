package farkvar.com.data.remote.model.buslist.satisIslemi

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SatisIslemiRequest(
    @SerializedName("passengers[0][seatNumber]")
    @Expose
    val seatNumber0: String? = null,

    @SerializedName("passengers[0][name]")
    @Expose
    val  name0: String? = null,


    @SerializedName("passengers[0][surname]")
    @Expose
    val  surname0: String? = null,


    @SerializedName("passengers[0][trCitizen]")
    @Expose
    val  citizen0: String? = null,


    @SerializedName("passengers[0][tc]")
    @Expose
    val tc0: String? = null,


    @SerializedName("passengers[1][seatNumber]")
    @Expose
    val seatNumber1: String? = null,


    @SerializedName("passengers[1][name]")
    @Expose
    val name1: String? = null,


    @SerializedName("passengers[1][surname]")
    @Expose
    val surname1: String? = null,


    @SerializedName("passengers[1][tc]")
    @Expose
    val tc1: String? = null,


    @SerializedName("phone")
    @Expose
    val phone: String? = null,


    @SerializedName("gender")
    @Expose
    val gender: String? = null,


    @SerializedName("totalPrice")
    @Expose
    val totalPrice: String? = null,


    @SerializedName("email")
    @Expose
    val email: String? = null
)