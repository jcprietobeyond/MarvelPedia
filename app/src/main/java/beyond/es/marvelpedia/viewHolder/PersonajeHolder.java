package beyond.es.marvelpedia.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import beyond.es.marvelpedia.R;
import beyond.es.marvelpedia.dto.model.Personaje;

/**
 * Created by BEYONDPC34 on 02/12/2015.
 */
public class PersonajeHolder extends RecyclerView.ViewHolder {
    private final ImageView logo;
    private final TextView nombre;
    private final TextView descripcion;
    private final View view;

    public PersonajeHolder(View itemView) {
        super(itemView);
        logo = (ImageView) itemView.findViewById(R.id.logoPersonaje);
        nombre = (TextView) itemView.findViewById(R.id.nombrePersonaje);
        descripcion = (TextView) itemView.findViewById(R.id.descripcionPersonaje);
        view = itemView;
    }

    public void setPersonaje(Personaje personaje) {
        nombre.setText(personaje.getNombre());
        descripcion.setText(personaje.getDescripcion());
        Picasso.with(view.getContext()).load(personaje.getURLLogo()).into(logo);
    }

    public View getView() {
        return view;
    }
}
