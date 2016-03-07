package beyond.es.marvelpedia.contentProvider.dao;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;

import beyond.es.marvelpedia.contentProvider.model.PersonajeContract;

/**
 * Created by BEYONDPC34 on 07/03/2016.
 */
public class MyContentProvider extends ContentProvider {

    private static final UriMatcher sUri_matcher = createUriMatcher();

    private static UriMatcher createUriMatcher() {
        final UriMatcher resultUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        resultUriMatcher.addURI(CONTENT_AUTHORITY,"personaje",PERSONAJES);
        resultUriMatcher.addURI(CONTENT_AUTHORITY,"personaje/#", PERSONAJE_BY_NAME);
        return resultUriMatcher;
    }

    private MySQLHelper helper;

    public static final String CONTENT_AUTHORITY = "beyond.es.marvelpedia";
    public static final String CURSOR_DIR_BASE_TYPE = "vnd.android.cursor.dir";
    public static final String ANY_CURSOR_ITEM_TYPE = "vnd.android.cursor.item";

    private static final int PERSONAJES = 100;
    private static final int PERSONAJE_BY_NAME = 101;

    public static final Uri PERSONAJE_URI = Uri.parse("content://"+CONTENT_AUTHORITY+"/personaje");

    @Override
    public boolean onCreate() {
        helper = new MySQLHelper(getContext(),MySQLHelper.DATABASE_NAME,MySQLHelper.DATABASE_VERSION);
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        int match = sUri_matcher.match(uri);
        switch (match) {
            case PERSONAJES:
                return helper.getReadableDatabase().query(PersonajeContract.PersonajeEntity.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
            case PERSONAJE_BY_NAME:
                String personajeId = uri.getLastPathSegment();
                String where = PersonajeContract.PersonajeEntity.COLUMN_NAME + "= ?";
                return helper.getReadableDatabase().query(PersonajeContract.PersonajeEntity.TABLE_NAME, projection, where, new String[]{personajeId}, null, null, sortOrder);
            default:
                throw new UnsupportedOperationException("Unknow uri:" +uri);
        }
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        int match = sUri_matcher.match(uri);
        switch (match) {
            case PERSONAJES:
                return CURSOR_DIR_BASE_TYPE+"/"+CONTENT_AUTHORITY+"/personaje";
            case PERSONAJE_BY_NAME:
                return ANY_CURSOR_ITEM_TYPE+"/"+CONTENT_AUTHORITY+"/personaje";
            default:
                throw new UnsupportedOperationException("Unknow uri:" +uri);
        }
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        int match = sUri_matcher.match(uri);
        switch (match) {
            case PERSONAJES:
                long id = helper.getReadableDatabase().insert(PersonajeContract.PersonajeEntity.TABLE_NAME, null, values);
                return Uri.parse(CONTENT_AUTHORITY + "/personaje/" + id);
            default:
                throw new UnsupportedOperationException("Unknow uri:" +uri);
        }
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
