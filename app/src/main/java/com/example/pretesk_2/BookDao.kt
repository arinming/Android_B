package com.example.pretesk_2

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface BookDao {
    @Query("SELECT * FROM book")
    fun getAll(): List<Book>

    @Insert(onConflict = REPLACE)
    fun insert(book: Book)

    @Query("DELETE from book")
    fun deleteAll()
}