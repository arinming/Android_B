package com.example.preteskproject

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Book::class], version = 1)
abstract class BookDB: RoomDatabase() {
    abstract fun bookDao(): BookDao

    companion object {
        private var INSTANCE: BookDB? = null

        fun getInstance(context: Context): BookDB? {
            if (INSTANCE == null) {
                synchronized(BookDB::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        BookDB::class.java, "book.db")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }
        fun destroyInstance() {
            INSTANCE = null
        }
    }
}