package com.sagarkhurana.quizforfun.data;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sagarkhurana.quizforfun.Classes.QuestionModel;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class QuestionDao_Impl implements QuestionDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<QuestionModel> __insertionAdapterOfQuestionModel;

  private final EntityInsertionAdapter<Attempt> __insertionAdapterOfAttempt;

  private final EntityDeletionOrUpdateAdapter<QuestionModel> __deletionAdapterOfQuestionModel;

  private final EntityDeletionOrUpdateAdapter<QuestionModel> __updateAdapterOfQuestionModel;

  public QuestionDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfQuestionModel = new EntityInsertionAdapter<QuestionModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `question` (`question`,`option1`,`option2`,`option3`,`option4`,`correctAnNum`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, QuestionModel value) {
        if (value.getQuestion() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getQuestion());
        }
        if (value.getOption1() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getOption1());
        }
        if (value.getOption2() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getOption2());
        }
        if (value.getOption3() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getOption3());
        }
        if (value.getOption4() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getOption4());
        }
        stmt.bindLong(6, value.getCorrectAnNum());
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
    this.__deletionAdapterOfQuestionModel = new EntityDeletionOrUpdateAdapter<QuestionModel>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `question` WHERE `question` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, QuestionModel value) {
        if (value.getQuestion() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getQuestion());
        }
      }
    };
    this.__updateAdapterOfQuestionModel = new EntityDeletionOrUpdateAdapter<QuestionModel>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `question` SET `question` = ?,`option1` = ?,`option2` = ?,`option3` = ?,`option4` = ?,`correctAnNum` = ? WHERE `question` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, QuestionModel value) {
        if (value.getQuestion() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getQuestion());
        }
        if (value.getOption1() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getOption1());
        }
        if (value.getOption2() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getOption2());
        }
        if (value.getOption3() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getOption3());
        }
        if (value.getOption4() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getOption4());
        }
        stmt.bindLong(6, value.getCorrectAnNum());
        if (value.getQuestion() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getQuestion());
        }
      }
    };
  }

  @Override
  public void insertQuestion(final QuestionModel question) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfQuestionModel.insert(question);
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
  public void deleteQuestion(final QuestionModel question) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfQuestionModel.handle(question);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateQuestion(final QuestionModel question) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfQuestionModel.handle(question);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<QuestionModel> observeAllQuestions() {
    final String _sql = "SELECT * FROM question";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfQuestion = CursorUtil.getColumnIndexOrThrow(_cursor, "question");
      final int _cursorIndexOfOption1 = CursorUtil.getColumnIndexOrThrow(_cursor, "option1");
      final int _cursorIndexOfOption2 = CursorUtil.getColumnIndexOrThrow(_cursor, "option2");
      final int _cursorIndexOfOption3 = CursorUtil.getColumnIndexOrThrow(_cursor, "option3");
      final int _cursorIndexOfOption4 = CursorUtil.getColumnIndexOrThrow(_cursor, "option4");
      final int _cursorIndexOfCorrectAnNum = CursorUtil.getColumnIndexOrThrow(_cursor, "correctAnNum");
      final List<QuestionModel> _result = new ArrayList<QuestionModel>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final QuestionModel _item;
        final String _tmpQuestion;
        _tmpQuestion = _cursor.getString(_cursorIndexOfQuestion);
        final String _tmpOption1;
        _tmpOption1 = _cursor.getString(_cursorIndexOfOption1);
        final String _tmpOption2;
        _tmpOption2 = _cursor.getString(_cursorIndexOfOption2);
        final String _tmpOption3;
        _tmpOption3 = _cursor.getString(_cursorIndexOfOption3);
        final String _tmpOption4;
        _tmpOption4 = _cursor.getString(_cursorIndexOfOption4);
        _item = new QuestionModel(_tmpQuestion,_tmpOption1,_tmpOption2,_tmpOption3,_tmpOption4);
        final int _tmpCorrectAnNum;
        _tmpCorrectAnNum = _cursor.getInt(_cursorIndexOfCorrectAnNum);
        _item.setCorrectAnNum(_tmpCorrectAnNum);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
