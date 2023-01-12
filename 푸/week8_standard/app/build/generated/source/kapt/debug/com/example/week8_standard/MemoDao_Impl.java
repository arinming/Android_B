package com.example.week8_standard;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MemoDao_Impl implements MemoDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Memo> __insertionAdapterOfMemo;

  public MemoDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMemo = new EntityInsertionAdapter<Memo>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Memo` (`memo`,`userId`) VALUES (?,nullif(?, 0))";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Memo value) {
        if (value.getMemo() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getMemo());
        }
        stmt.bindLong(2, value.getUserId());
      }
    };
  }

  @Override
  public void insert(final Memo memo) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfMemo.insert(memo);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Memo> selectAll() {
    final String _sql = "SELECT * FROM memo";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfMemo = CursorUtil.getColumnIndexOrThrow(_cursor, "memo");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
      final List<Memo> _result = new ArrayList<Memo>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Memo _item;
        final String _tmpMemo;
        if (_cursor.isNull(_cursorIndexOfMemo)) {
          _tmpMemo = null;
        } else {
          _tmpMemo = _cursor.getString(_cursorIndexOfMemo);
        }
        final int _tmpUserId;
        _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
        _item = new Memo(_tmpMemo,_tmpUserId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Memo> selectByUserName(final String memo) {
    final String _sql = "SELECT * FROM Memo WHERE memo = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (memo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, memo);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfMemo = CursorUtil.getColumnIndexOrThrow(_cursor, "memo");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
      final List<Memo> _result = new ArrayList<Memo>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Memo _item;
        final String _tmpMemo;
        if (_cursor.isNull(_cursorIndexOfMemo)) {
          _tmpMemo = null;
        } else {
          _tmpMemo = _cursor.getString(_cursorIndexOfMemo);
        }
        final int _tmpUserId;
        _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
        _item = new Memo(_tmpMemo,_tmpUserId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
