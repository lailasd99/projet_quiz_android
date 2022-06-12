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
public final class QuizDatabase_Impl extends QuizDatabase {
  private volatile QuizDao _quizDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `quiz` (`titre` TEXT NOT NULL, PRIMARY KEY(`titre`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `attempt` (`createdTimeAttempt` INTEGER NOT NULL, `subject` TEXT, `correct` INTEGER NOT NULL, `incorrect` INTEGER NOT NULL, `earned` INTEGER NOT NULL, `email` TEXT, `overallPoints` INTEGER NOT NULL, PRIMARY KEY(`createdTimeAttempt`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '5a70ae2c529bdde91446663ab040df13')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `quiz`");
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
        final HashMap<String, TableInfo.Column> _columnsQuiz = new HashMap<String, TableInfo.Column>(1);
        _columnsQuiz.put("titre", new TableInfo.Column("titre", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysQuiz = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesQuiz = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoQuiz = new TableInfo("quiz", _columnsQuiz, _foreignKeysQuiz, _indicesQuiz);
        final TableInfo _existingQuiz = TableInfo.read(_db, "quiz");
        if (! _infoQuiz.equals(_existingQuiz)) {
          return new RoomOpenHelper.ValidationResult(false, "quiz(com.sagarkhurana.quizforfun.data.QuizModel).\n"
                  + " Expected:\n" + _infoQuiz + "\n"
                  + " Found:\n" + _existingQuiz);
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
    }, "5a70ae2c529bdde91446663ab040df13", "d9543dcfc300b284358d760d4d51b57a");
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
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "quiz","attempt");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `quiz`");
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
  public QuizDao quizDao() {
    if (_quizDao != null) {
      return _quizDao;
    } else {
      synchronized(this) {
        if(_quizDao == null) {
          _quizDao = new QuizDao_Impl(this);
        }
        return _quizDao;
      }
    }
  }
}
