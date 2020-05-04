package com.mvvmofflineapp.listeners

import com.mvvmofflineapp.model.CommonApiResponse
import retrofit2.Call
import retrofit2.Response

interface callBackListner {
    fun onResponse(requestCode: Int, call: Call<CommonApiResponse>, response: Response<CommonApiResponse>)
    fun onFailure(requestCode: Int, call: Call<CommonApiResponse>, t: Throwable)
}