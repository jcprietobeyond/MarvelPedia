package beyond.es.marvelpedia.dao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import beyond.es.marvelpedia.model.Personaje;

/**
 * Created by BEYONDPC34 on 14/12/2015.
 */
public class PersonajeDAO {

    private static LinkedList<Personaje> personajes;

    public static void save(List<Personaje> listado) {
        if (personajes != null) {
            personajes.clear();
            personajes.addAll(listado);
        } else {
            personajes = new LinkedList<Personaje>(listado);
        }
    }

    public static Personaje getById(int id) {
        return personajes.get(id);
    }
}
