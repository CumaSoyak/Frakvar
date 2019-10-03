package farkvar.com.data.remote.model.base

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class BaseMessageResponse (
    @SerializedName("code")
    @Expose
    val code: String = "",
    @SerializedName("title")
    @Expose
    val title: String = "",
    @SerializedName("message")
    @Expose
    val message: String = ""
)