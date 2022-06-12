package com.sagarkhurana.quizforfun.data;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class QuestionDatabase_Impl extends QuestionDatabase {
  private volatile QuestionDao _questionDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `question` (`question` TEXT NOT NULL, `option1` TEXT, `option2` TEXT, `option3` TEXT, `option4` TEXT, `correctAnNum` INTEGER NOT NULL, PRIMARY KEY(`question`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `attempt` (`createdTimeAttempt` INTEGER NOT NULL, `subject` TEXT, `correct` INTEGER NOT NULL, `incorrect` INTEGER NOT NULL, `earned` INTEGER NOT NULL, `email` TEXT, `overallPoints` INTEGER NOT NULL, PRIMARY KEY(`createdTimeAttempt`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'aae5a141ffcbf3e19fc0c4e4c530f96f')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `question`");
        _db.execSQL("DROP TABLE IF EXISTS `attempt`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsQuestion = new HashMap<String, TableInfo.Column>(6);
        _columnsQuestion.put("question", new TableInfo.Column("question", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsQuestion.put("option1", new TableInfo.Column("option1", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsQuestion.put("option2", new TableInfo.Column("option2", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsQuestion.put("option3", new TableInfo.Column("option3", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsQuestion.put("option4", new TableInfo.Column("option4", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsQuestion.put("correctAnNum", new TableInfo.Column("correctAnNum", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysQuestion = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesQuestion = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoQuestion = new TableInfo("question", _columnsQuestion, _foreignKeysQuestion, _indicesQuestion);
        final TableInfo _existingQuestion = TableInfo.read(_db, "question");
        if (! _infoQuestion.equals(_existingQuestion)) {
          return new RoomOpenHelper.ValidationResult(false, "question(com.sagarkhurana.quizforfun.Classes.QuestionModel).\n"
                  + " Expected:\n" + _infoQuestion + "\n"
                  + " Found:\n" + _existingQuestion);
        }
        final HashMap<String, TableInfo.Column> _columnsAttempt = new HashMap<String, TableInfo.Column>(7);
        _columnsAttempt.put("createdTimeAttempt", new TableInfo.Column("createdTimeAttempt", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttempt.put("subject", new TableInfo.Column("subject", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttempt.put("correct", new TableInfo.Column("correct", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttempt.put("incorrect", new TableInfo.Column("incorrect", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttempt.put("earned", new TableInfo.Column("earned", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttempt.put("email", new TableInfo.Column("email", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttempt.put("overallPoints", new TableInfo.Column("overallPoints", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAttempt = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAttempt = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAttempt = new TableInfo("attempt", _columnsAttempt, _foreignKeysAttempt, _indicesAttempt);
        final TableInfo _existingAttempt = TableInfo.read(_db, "attempt");
        if (! _infoAttempt.equals(_existingAttempt)) {
          return new RoomOpenHelper.ValidationResult(false, "attempt(com.sagarkhurana.quizforfun.data.Attempt).\n"
                  + " Expected:\n" + _infoAttempt + "\n"
                  + " Found:\n" + _existingAttempt);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "aae5a141ffcbf3e19fc0c4e4c530f96f", "fe4a3371c49ed53889d26501d01be7d0");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "question","attempt");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `question`");
      _db.execSQL("DELETE FROM `attempt`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public QuestionDao questionDao() {
    if (_questionDao != null) {
      return _questionDao;
    } else {
      synchronized(this) {
        if(_questionDao == null) {
          _questionDao = new QuestionDao_Impl(this);
        }
        return _questionDao;
      }
    }
  }
}
