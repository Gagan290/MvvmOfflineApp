package com.mvvmofflineapp.repository.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.mvvmofflineapp.repository.database.tables.TableResult

@Dao
interface CommonDao {

    //Query for whole table
    @Query("SELECT * FROM " + DbConfig.TABLE_NAME)
    fun getAllUsers(): List<TableResult>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUser(result: TableResult?)

    //Query to delete latest entry
    @Query("DELETE FROM " + DbConfig.TABLE_NAME + " WHERE ID = (SELECT MAX(id) FROM " + DbConfig.TABLE_NAME + ")")
    fun deleteSingleUser()

    //Query to delete all entries
    @Query("DELETE FROM " + DbConfig.TABLE_NAME)
    fun deleteAllUsers()
}
