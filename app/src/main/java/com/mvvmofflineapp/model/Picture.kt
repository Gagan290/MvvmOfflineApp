package com.mvvmofflineapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by sneh.pandya on 13/11/17.
 */

class Picture {

    @SerializedName("large")
    @Expose
    var large: String? = null

    @SerializedName("medium")
    @Expose
    var medium: String? = null

    @SerializedName("thumbnail")
    @Expose
    var thumbnail: String? = null
}
