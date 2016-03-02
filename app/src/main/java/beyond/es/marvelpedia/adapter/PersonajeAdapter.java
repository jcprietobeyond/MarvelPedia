package beyond.es.marvelpedia.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import beyond.es.marvelpedia.DescripcionActivity;
import beyond.es.marvelpedia.R;
import beyond.es.marvelpedia.model.Personaje;
import beyond.es.marvelpedia.viewHolder.PersonajeHolder;

/**
 * Created by BEYONDPC34 on 02/12/2015.
 */
public class PersonajeAdapter extends RecyclerView.Adapter {

    List<Personaje> list;

    public PersonajeAdapter (List<Personaje> list) {
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.personaje, parent, false);
        return new PersonajeHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        ((PersonajeHolder) holder).setPersonaje(list.get(position));
        final View view = ((PersonajeHolder) holder).getView();
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), DescripcionActivity.class);
                intent.putExtra("posicion",position);
                view.getContext().startActivity(intent);
                /*Toast toast = Toast.makeText(view.getContext(), "Hola " + position, Toast.LENGTH_SHORT);
                toast.show();*/
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
