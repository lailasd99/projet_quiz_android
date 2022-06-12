package com.sagarkhurana.quizforfun.data;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class QuizDao_Impl implements QuizDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<QuizModel> __insertionAdapterOfQuizModel;

  private final EntityInsertionAdapter<Attempt> __insertionAdapterOfAttempt;

  private final EntityDeletionOrUpdateAdapter<QuizModel> __deletionAdapterOfQuizModel;

  private final EntityDeletionOrUpdateAdapter<QuizModel> __updateAdapterOfQuizModel;

  public QuizDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfQuizModel = new EntityInsertionAdapter<QuizModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `quiz` (`titre`) VALUES (?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, QuizModel value) {
        if (value.getTitre() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTitre());
        }
      }
    };
    this.__insertionAdapterOfAttempt = new EntityInsertionAdapter<Attempt>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `attempt` (`createdTimeAttempt`,`subject`,`correct`,`incorrect`,`earned`,`email`,`overallPoints`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Attempt value) {
        stmt.bindLong(1, value.getCreatedTime());
        if (value.getSubject() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSubject());
        }
        stmt.bindLong(3, value.getCorrect());
        stmt.bindLong(4, value.getIncorrect());
        stmt.bindLong(5, value.getEarned());
        if (value.getEmail() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getEmail());
        }
        stmt.bindLong(7, value.getOverallPoints());
      }
    };
    this.__deletionAdapterOfQuizModel = new EntityDeletionOrUpdateAdapter<QuizModel>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `quiz` WHERE `titre` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, QuizModel value) {
        if (value.getTitre() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTitre());
        }
      }
    };
    this.__updateAdapterOfQuizModel = new EntityDeletionOrUpdateAdapter<QuizModel>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `quiz` SET `titre` = ? WHERE `titre` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, QuizModel value) {
        if (value.getTitre() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTitre());
        }
        if (value.getTitre() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitre());
        }
      }
    };
  }

  @Override
  public void insertQuiz(final QuizModel quiz) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfQuizModel.insert(quiz);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertAttempt(final Attempt attempt) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfAttempt.insert(attempt);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteQuiz(final QuizModel quiz) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfQuizModel.handle(quiz);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateQuiz(final QuizModel quiz) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfQuizModel.handle(quiz);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<QuizModel> observeAllQuiz() {
    final String _sql = "SELECT * FROM quiz";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTitre = CursorUtil.getColumnIndexOrThrow(_cursor, "titre");
      final List<QuizModel> _result = new ArrayList<QuizModel>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final QuizModel _item;
        _item = new QuizModel();
        final String _tmpTitre;
        _tmpTitre = _cursor.getString(_cursorIndexOfTitre);
        _item.setTitre(_tmpTitre);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<QuizModel> getQuiz() {
    final String _sql = "SELECT * FROM quiz";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
      try {
        final int _cursorIndexOfTitre = CursorUtil.getColumnIndexOrThrow(_cursor, "titre");
        final List<QuizModel> _result = new ArrayList<QuizModel>(_cursor.getCount());
        while(_cursor.moveToNext()) {
          final QuizModel _item;
          _item = new QuizModel();
          final String _tmpTitre;
          _tmpTitre = _cursor.getString(_cursorIndexOfTitre);
          _item.setTitre(_tmpTitre);
          _result.add(_item);
        }
        __db.setTransactionSuccessful();
        return _result;
      } finally {
        _cursor.close();
        _statement.release();
      }
    } finally {
      __db.endTransaction();
    }
  }
}
