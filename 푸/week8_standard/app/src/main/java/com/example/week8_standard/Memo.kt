package com.example.week8_standard

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Memo(
    @ColumnInfo(name = "memo") val memo: String,
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "userId") val userId: Int = 0
)
