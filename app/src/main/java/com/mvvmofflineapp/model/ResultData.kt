package com.mvvmofflineapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by sneh.pandya on 10/11/17.
 */

class ResultData {

    @SerializedName("gender")
    @Expose
    var gender: String? = null

    @SerializedName("name")
    @Expose
    var name: Name? = null

    @SerializedName("picture")
    @Expose
    var picture: Picture? = null

    @SerializedName("nat")
    @Expose
    var nat: String? = null
}
