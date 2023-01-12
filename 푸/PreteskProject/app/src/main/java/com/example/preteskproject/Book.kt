package com.example.preteskproject

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book")
class Book (
    @PrimaryKey var id: Long?,
    @ColumnInfo(name = "bookname") var bookName: String
){
    constructor(): this(null,"")
}