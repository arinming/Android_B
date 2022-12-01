package com.example.week8_standard

import android.content.Intent
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MemoDao {
    @Query("SELECT * FROM memo")
    fun selectAll() : List<Memo>

    @Insert
    fun insert(memo: Memo)

    @Query("SELECT * FROM Memo WHERE memo = :memo")
    fun selectByUserName(memo: String): List<Memo>
}