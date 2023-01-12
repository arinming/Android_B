package com.example.week8;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\'J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\'J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\r\u001a\u00020\u000eH\'J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\'\u00a8\u0006\u0010"}, d2 = {"Lcom/example/week8/UserDao;", "", "delete", "", "user", "Lcom/example/week8/User;", "insert", "selectAll", "", "selectByUserId", "userId", "", "selectByUserName", "name", "", "updateNameByUserId", "app_debug"})
public abstract interface UserDao {
    
    @androidx.room.Insert()
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    com.example.week8.User user);
    
    @androidx.room.Delete()
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    com.example.week8.User user);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM User")
    public abstract java.util.List<com.example.week8.User> selectAll();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM User WHERE userId = :userId")
    public abstract com.example.week8.User selectByUserId(int userId);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM User WHERE name = :name")
    public abstract java.util.List<com.example.week8.User> selectByUserName(@org.jetbrains.annotations.NotNull()
    java.lang.String name);
    
    @androidx.room.Query(value = "UPDATE User SET name = :name WHERE userId = :userId")
    public abstract void updateNameByUserId(int userId, @org.jetbrains.annotations.NotNull()
    java.lang.String name);
}