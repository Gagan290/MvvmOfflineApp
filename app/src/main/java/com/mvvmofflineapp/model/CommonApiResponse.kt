package com.mvvmofflineapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import okhttp3.Response

open class CommonApiResponse {
    @SerializedName("results")
    @Expose
    var results: ArrayList<ResultData>? = null

    @SerializedName("info")
    @Expose
    var info: Info? = null

    var message: String = ""
    var resultCode: Int = 0
    var dbDataAvailable = 0
    var internetAvailable = 0

    var response: Response? = null
}
