package com.mvvmofflineapp.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.mvvmofflineapp.model.ListDataModel
import com.mvvmofflineapp.repository.CommonRepository

class CommonViewModel(application: Application) : AndroidViewModel(application) {
    private var repository: CommonRepository? = null

    init {
        repository = CommonRepository(application)
    }

    fun getListData(): LiveData<ListDataModel>? {
        val listLiveData: LiveData<ListDataModel>?
        listLiveData = repository?.loadData()

        return listLiveData
    }
}
