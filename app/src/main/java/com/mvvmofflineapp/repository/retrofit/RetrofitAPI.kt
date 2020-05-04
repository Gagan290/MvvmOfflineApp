package com.mvvmofflineapp.repository.retrofit

import android.util.Log
import com.mvvmofflineapp.listeners.callBackListner
import com.mvvmofflineapp.model.CommonApiResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.security.auth.callback.Callback

object RetrofitAPI {

    private val mRetrofit = Retrofit.Builder()
        .baseUrl(ApiConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    var retrofitInstance: ApiInterface = mRetrofit.create(ApiInterface::class.java)


    //Call Request
    //private fun callRequest(apiCode: Int, map: HashMap<String, Any>?): Call<CommonApiResponse>? {
    /*private fun callRequest(apiCode: Int, anyObject: Any?): Call<CommonApiResponse>? {
        var call: Call<CommonApiResponse>? = null

        if (apiCode == 100) {
            var obj = anyObject as Int
            call = retrofitInstance.getRandomUsers(obj)
        }

        return call
    }*/

    //Api Calling
    fun callRetrofitApi(apiCode: Int, call: Call<CommonApiResponse>?, callBackListner: callBackListner) {
        /*val call = callRequest(apiCode, anyObject)
        Log.e("CommonRepository", "request " + call?.request())*/
        Log.e("RetrofitAPI", "request " + call?.request())

        call?.enqueue(object : Callback, retrofit2.Callback<CommonApiResponse> {
            override fun onFailure(call: Call<CommonApiResponse>, t: Throwable) {
                callBackListner.onFailure(apiCode, call, t)
            }

            override fun onResponse(call: Call<CommonApiResponse>, response: Response<CommonApiResponse>) {
                callBackListner.onResponse(apiCode, call, response)
            }
        })
    }


}
