package beyond.es.marvelpedia.json.sync;

import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import beyond.es.marvelpedia.adapter.PersonajeAdapter;
import beyond.es.marvelpedia.json.converter.JsonPersonajeConverter;
import beyond.es.marvelpedia.json.model.CharacterDataWrapper;
import beyond.es.marvelpedia.dto.model.Personaje;
import beyond.es.marvelpedia.modelo.DaoMaster;
import beyond.es.marvelpedia.modelo.DaoSession;

/**
 * Created by BEYONDPC34 on 03/12/2015.
 */
public class MarvelJsonTask extends AsyncTask<Void, Void, CharacterDataWrapper> {

    private String url;
    private String jsonResponse;
    private RecyclerView recyclerView;

    public MarvelJsonTask(String url, RecyclerView recyclerView) {
        this.url = url;
        this.recyclerView = recyclerView;
    }

    @Override
    protected CharacterDataWrapper doInBackground(Void...param) {
        Uri uri = Uri.parse(this.url);
        HttpURLConnection urlConection = null;
        BufferedReader reader = null;
        CharacterDataWrapper dataWrapper = new CharacterDataWrapper();
        try {
            URL url = new URL(uri.toString());
            urlConection = (HttpURLConnection) url.openConnection();
            urlConection.setRequestMethod("GET");
            urlConection.connect();

            InputStream inputStream = urlConection.getInputStream();
            StringBuffer stringBuffer = new StringBuffer();

            reader = new BufferedReader(new InputStreamReader(inputStream));

            String linea = null;
            while ((linea = reader.readLine()) != null) {
                stringBuffer.append(linea);
            }
            this.jsonResponse = stringBuffer.toString();

            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            dataWrapper = mapper.readValue(jsonResponse, CharacterDataWrapper.class);
        } catch (MalformedURLException e) {
            Log.e("TASK-ERROR","MalformedURLException",e);
        } catch (IOException e) {
            Log.e("TASK-ERROR", "IOException", e);
        } finally {
            urlConection.disconnect();
            try {
                reader.close();
            } catch (IOException e) {
                Log.e("TASK-ERROR", "IOException", e);
            }
        }
        return dataWrapper;
    }

    @Override
    protected void onPostExecute(CharacterDataWrapper characterDataWrapper) {
        super.onPostExecute(characterDataWrapper);
        if (recyclerView != null) {
            List<Personaje> listado = JsonPersonajeConverter.getList(characterDataWrapper);
            DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(recyclerView.getContext(), "marvelPediaBD", null);
            DaoMaster master = new DaoMaster(helper.getWritableDatabase());
            DaoSession sesion = master.newSession();
            for (Personaje personaje : listado) {
                beyond.es.marvelpedia.modelo.Personaje personajeBBDD = new beyond.es.marvelpedia.modelo.Personaje();
                personajeBBDD.setId(personaje.getId());
                personajeBBDD.setNombre(personaje.getNombre());
                personajeBBDD.setDescripcion(personaje.getDescripcion());
                personajeBBDD.setURLImagen(personaje.getURLImagen());
                personajeBBDD.setURLLogo(personaje.getURLLogo());
                sesion.insert(personajeBBDD);
            }
            recyclerView.setAdapter(new PersonajeAdapter(listado));
        }
    }

}
