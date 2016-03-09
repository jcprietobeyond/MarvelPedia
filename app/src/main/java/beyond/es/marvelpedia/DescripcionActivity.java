package beyond.es.marvelpedia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import beyond.es.marvelpedia.modelo.DaoMaster;
import beyond.es.marvelpedia.modelo.DaoSession;
import beyond.es.marvelpedia.modelo.Personaje;
import butterknife.Bind;
import butterknife.ButterKnife;

public class DescripcionActivity extends AppCompatActivity {

    @Bind(R.id.imagenPersonaje)
    ImageView imagenPersonaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion);
        ButterKnife.bind(this);

        int posicion = getIntent().getExtras().getInt("posicion");
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(getApplicationContext(), "marvelPediaBD", null);
        DaoMaster master = new DaoMaster(helper.getWritableDatabase());
        DaoSession sesion = master.newSession();
        Personaje personajeBBDD = sesion.getPersonajeDao().load(Long.valueOf(posicion));
        Picasso.with(getApplicationContext()).load(personajeBBDD.getURLImagen()).into(imagenPersonaje);
    }

}
