package com.example.preteskproject

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface BookDao {
    @Query("SELECT * FROM book")
    fun getAll(): List<Book>

    @Insert(onConflict = REPLACE)
    fun insert(book: Book)

    @Query("DELETE From book")
    fun deleteAll()

    @Delete
    fun deleteBook(book: Book)
}