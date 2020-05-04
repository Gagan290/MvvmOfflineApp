package com.mvvmofflineapp.repository

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.mvvmofflineapp.listeners.callBackListner
import com.mvvmofflineapp.model.CommonApiResponse
import com.mvvmofflineapp.model.ListDataModel
import com.mvvmofflineapp.model.ResultData
import com.mvvmofflineapp.repository.database.AppDatabase
import com.mvvmofflineapp.repository.database.tables.TableResult
import com.mvvmofflineapp.repository.retrofit.RetrofitAPI
import retrofit2.Call
import retrofit2.Response

class CommonRepository(application: Application) {
    private var mAppDatabase: AppDatabase? = null
    private val mResultsList = ArrayList<ResultData>()

    init {
        mAppDatabase = AppDatabase.getInstance(application)
    }

    fun loadData(): MutableLiveData<ListDataModel> {

        //SharedPrefsCache.getString()
        val data = MutableLiveData<ListDataModel>()

        val dbList = mAppDatabase?.mCommonDao()?.getAllUsers() as ArrayList<TableResult>?
        if (dbList?.size!! > 0) {
            val model = ListDataModel()
            model.resultsList = dbList
            model.resultCode = 200
            model.dbDataAvailable = 1
            model.internetAvailable = 0
            model.message = "Api response successfull"
            data.value = model
        } else {
            val model = ListDataModel()
            model.resultsList = dbList
            model.resultCode = 0
            model.dbDataAvailable = 0
            model.internetAvailable = 0
            model.message = "Api response successfull"
            data.value = model
        }

        val call = RetrofitAPI.retrofitInstance.getRandomUsers(10)
        RetrofitAPI.callRetrofitApi(100, call, object : callBackListner {
            override fun onResponse(
                requestCode: Int,
                call: Call<CommonApiResponse>, response: Response<CommonApiResponse>
            ) {

                Log.e("CommonRepository", "url " + call.request().url())
                Log.e("CommonRepository", "request " + call.request())
                Log.e("CommonRepository", "response body " + response.body())

                response.body()?.results?.let { mResultsList.addAll(it) }
                val arrayList: ArrayList<TableResult>? = ArrayList()

                if (mResultsList.size > 0) {
                    mAppDatabase?.mCommonDao()?.deleteAllUsers()
                }

                var mTableResult: TableResult?
                for (i in mResultsList.indices) {
                    mTableResult = TableResult(
                        mResultsList[i].name?.title,
                        mResultsList[i].name?.first,
                        mResultsList[i].name?.last,
                        mResultsList[i].gender,
                        mResultsList[i].picture?.large,
                        mResultsList[i].nat
                    )
                    mAppDatabase?.mCommonDao()?.addUser(mTableResult)

                    arrayList?.add(mTableResult)
                }
                if (arrayList?.size!! > 0) {
                    val model = ListDataModel()
                    model.resultsList = arrayList
                    model.resultCode = 200
                    model.internetAvailable = 1
                    model.dbDataAvailable = 0
                    model.message = "Api response successfull"

                    data.value = model
                }
            }

            override fun onFailure(requestCode: Int, call: Call<CommonApiResponse>, t: Throwable) {
                Log.e("CommonRepository", "response Failure " + t.message)
                val model = ListDataModel()
                model.resultsList = null
                model.resultCode = 0
                model.internetAvailable = 0
                model.dbDataAvailable = 0
                model.message = "Api response failed"
                data.value = model
            }
        })

        return data
    }
}