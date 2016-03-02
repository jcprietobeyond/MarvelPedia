package beyond.es.marvelpedia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.LinkedList;
import java.util.List;

import beyond.es.marvelpedia.adapter.PersonajeAdapter;
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
        setContentView(R.layout.activity_main);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        ButterKnife.bind(this);
        recycleViewListadoPersonajes.setLayoutManager(linearLayoutManager);
        MarvelJsonTask marvelJsonTask = new MarvelJsonTask("http://gateway.marvel.com/v1/public/characters?limit=100&apikey=2f441a7969bd6686bbeb84bd5214c983&ts=1&hash=ab5031c5708577c8005f99fec9d5fe01", recycleViewListadoPersonajes);
        marvelJsonTask.execute();
    }
}
