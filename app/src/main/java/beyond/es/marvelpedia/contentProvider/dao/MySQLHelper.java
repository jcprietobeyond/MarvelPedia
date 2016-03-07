package beyond.es.marvelpedia.contentProvider.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static beyond.es.marvelpedia.contentProvider.model.PersonajeContract.*;

/**
 * Created by BEYONDPC34 on 03/03/2016.
 */
public class MySQLHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "marvelpedia.db";

    final String SQL_CREATE_PERSONAJE_TABLE = "CREATE TABLE " + PersonajeEntity.TABLE_NAME + " (" +
            PersonajeEntity._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            PersonajeEntity.COLUMN_NAME + " TEXT NOT NULL, " +
            PersonajeEntity.COLUMN_DESCRIPCION + " TEXT NOT NULL); ";

    public MySQLHelper(Context context, String name, int version) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_PERSONAJE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
