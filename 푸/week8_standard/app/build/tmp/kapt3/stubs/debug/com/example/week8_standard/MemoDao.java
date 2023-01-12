package com.example.week8_standard;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\'J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\u0004\u001a\u00020\tH\'\u00a8\u0006\n"}, d2 = {"Lcom/example/week8_standard/MemoDao;", "", "insert", "", "memo", "Lcom/example/week8_standard/Memo;", "selectAll", "", "selectByUserName", "", "app_debug"})
public abstract interface MemoDao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM memo")
    public abstract java.util.List<com.example.week8_standard.Memo> selectAll();
    
    @androidx.room.Insert()
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    com.example.week8_standard.Memo memo);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM Memo WHERE memo = :memo")
    public abstract java.util.List<com.example.week8_standard.Memo> selectByUserName(@org.jetbrains.annotations.NotNull()
    java.lang.String memo);
}