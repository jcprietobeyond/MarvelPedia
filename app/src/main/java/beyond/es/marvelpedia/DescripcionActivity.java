package beyond.es.marvelpedia;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import beyond.es.marvelpedia.dao.PersonajeDAO;
import beyond.es.marvelpedia.model.Personaje;
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
        Personaje personaje = PersonajeDAO.getById(posicion);
        Picasso.with(getApplicationContext()).load(personaje.getURLImagen()).into(imagenPersonaje);
    }

}
