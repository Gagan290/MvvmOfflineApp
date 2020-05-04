package com.mvvmofflineapp.repository.database.tables

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.mvvmofflineapp.repository.database.DbConfig

@Entity(tableName = DbConfig.TABLE_NAME)
class TableResult(
    var title: String?,
    var firstName: String?,
    var lastName: String?,
    var gender: String?,
    var picture: String? = "",
    var nat: String?
) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
