package com.mvvmofflineapp.repository.retrofit

import com.mvvmofflineapp.model.CommonApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("/api/")
    fun getRandomUsers(@Query("results") results: Int): Call<CommonApiResponse>

    /*@GET("/api/")
    fun getRandomUsers(
        @Query("results") results: Int,
        @Query("exc") exclude: String,
        @Query("seed") seed: String
    ): Call<CommonApiResponse>*/
}
