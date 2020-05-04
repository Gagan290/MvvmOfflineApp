package com.mvvmofflineapp.model

import com.mvvmofflineapp.repository.database.tables.TableResult

class ListDataModel : CommonApiResponse() {

    var resultsList: ArrayList<TableResult>? = null
}