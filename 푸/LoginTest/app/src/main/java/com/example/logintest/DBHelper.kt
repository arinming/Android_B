package com.example.logintest

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context?) :
    SQLiteOpenHelper(context, "Login.db", null, 1) {
    // 새로운 테이블 형성
    override fun onCreate(MyDB: SQLiteDatabase) {
        MyDB.execSQL("create Table users(username TEXT primary key, password TEXT)")
    }

    // 정보 갱신
    override fun onUpgrade(MyDB: SQLiteDatabase, i: Int, i1: Int) {
        MyDB.execSQL("drop Table if exists users")
    }

    // username과 password 정보를 DB에 삽입
    // 삽입 성공시 true, 실패시 false
    fun insertData(username: String?, password: String?): Boolean {
        val MyDB = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("username", username)
        contentValues.put("password", password)
        val result = MyDB.insert("users", null, contentValues)
        return if (result == -1L) false else true
    }

    // 사용자 입력을 감지해 입력이 없을 경우 false, 입력 있을 경우 true 리턴
    fun checkUsername(username: String): Boolean {
        val MyDB = this.writableDatabase
        var res = true
        val cursor = MyDB.rawQuery("Select * from users where username = ?", arrayOf(username))
        if (cursor.count <= 0) res = false
        return res
    }

    // username이 존재하는지, password가 입력됐는지 확인
    // 입력이 안됐을 경우 false 리턴
    fun checkUserpass(username: String, password: String): Boolean {
        val MyDB = this.writableDatabase
        var res = true
        val cursor = MyDB.rawQuery(
            "Select * from users where username = ? and password = ?",
            arrayOf(username, password)
        )
        if (cursor.count <= 0 ) res = false
        return res
    }

    // object를 통해 DB name을 Login.db로 설정정
    companion object {
        const val DBNAME = "Login.db"
    }
}