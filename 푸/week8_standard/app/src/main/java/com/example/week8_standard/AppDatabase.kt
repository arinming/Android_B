package com.example.week8_standard

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Memo::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun memoDao(): MemoDao

    companion object {
        private var appDatabase: AppDatabase? = null


        // 여러 스레드에서 동시에 하나의 자원에 접근하려고 하는 것을 방지
        @Synchronized

        fun getInstance(context: Context) : AppDatabase? {
            if (appDatabase == null) {
                synchronized(AppDatabase::class.java) {
                    appDatabase = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "app-database"
                    ).allowMainThreadQueries().build()
                }
            }
            return appDatabase
        }

        fun destroyInstance() {
            appDatabase = null
        }
    }

}