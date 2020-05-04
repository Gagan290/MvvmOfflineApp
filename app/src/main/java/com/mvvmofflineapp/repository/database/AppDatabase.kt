package com.mvvmofflineapp.repository.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.mvvmofflineapp.repository.database.tables.TableResult

@Database(entities = [TableResult::class], version = DbConfig.DATABASE_VERSION)
abstract class AppDatabase : RoomDatabase() {

    abstract fun mCommonDao(): CommonDao

    companion object {
        private var INSTANCE: AppDatabase? = null
        //private val sLock = Any()

        fun getInstance(context: Context): AppDatabase {
            //synchronized(sLock) {
            synchronized(AppDatabase::class) {
                if (INSTANCE == null) {
                    /*INSTANCE = Room.databaseBuilder(context, AppDatabase::class.java, DbConfig.DATABASE_NAME)
                        .addMigrations(MIGRATION_1_2).allowMainThreadQueries().build()*/
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        DbConfig.DATABASE_NAME
                    )
                        .allowMainThreadQueries().build()
                }

                return INSTANCE as AppDatabase
            }
        }

        /*private val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                //database.execSQL("ALTER TABLE ResultData " + "ADD COLUMN picture TEXT")
            }
        }*/
    }
}
