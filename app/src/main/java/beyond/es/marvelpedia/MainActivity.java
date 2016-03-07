package beyond.es.marvelpedia;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

import beyond.es.marvelpedia.adapter.PersonajeAdapter;
import beyond.es.marvelpedia.contentProvider.dao.MyContentProvider;
import beyond.es.marvelpedia.contentProvider.dao.MySQLHelper;
import beyond.es.marvelpedia.contentProvider.model.PersonajeContract;
import beyond.es.marvelpedia.json.sync.MarvelJsonTask;
import beyond.es.marvelpedia.model.Personaje;
import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.recycleViewListadoPersonajes)
    RecyclerView recycleViewListadoPersonajes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ContentResolver contentResolver = getContentResolver();
        /*for (int i = 0; i<10; i++) {
            ContentValues value = new ContentValues();
            value.put(PersonajeContract.PersonajeEntity.COLUMN_NAME, "Persojane " + i);
            value.put(PersonajeContract.PersonajeEntity.COLUMN_DESCRIPCION, "Descripcion del personaje " + i);
            contentResolver.insert(MyContentProvider.PERSONAJE_URI, value);
        }*/
        Cursor cursor = contentResolver.query(MyContentProvider.PERSONAJE_URI, null, null, null, null);
        if (cursor.getCount() > 0) {
            do {
                Log.i("Personajes", cursor.getString(0));
            } while (cursor.moveToNext());
        }

        setContentView(R.layout.activity_main);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        ButterKnife.bind(this);
        recycleViewListadoPersonajes.setLayoutManager(linearLayoutManager);
        MarvelJsonTask marvelJsonTask = new MarvelJsonTask("http://gateway.marvel.com/v1/public/characters?&apikey=2f441a7969bd6686bbeb84bd5214c983&ts=1&hash=ab5031c5708577c8005f99fec9d5fe01", recycleViewListadoPersonajes);
        marvelJsonTask.execute();
    }
}
