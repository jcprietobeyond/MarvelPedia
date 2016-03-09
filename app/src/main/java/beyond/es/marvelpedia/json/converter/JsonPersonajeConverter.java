package beyond.es.marvelpedia.json.converter;

import java.util.ArrayList;
import java.util.List;

import beyond.es.marvelpedia.json.model.*;
import beyond.es.marvelpedia.dto.model.Personaje;

/**
 * Created by BEYONDPC34 on 09/12/2015.
 */
public class JsonPersonajeConverter {
    public static List<Personaje> getList(CharacterDataWrapper characterDataWrapper) {
        List<Personaje> personajes = new ArrayList<Personaje>();
        for (beyond.es.marvelpedia.json.model.Character character : characterDataWrapper.getData().getResults()) {
            Personaje personaje = new Personaje();
            personaje.setId(character.getId());
            personaje.setNombre(character.getNombre());
            personaje.setDescripcion(character.getDescripcion());
            personaje.setURLLogo(character.getImage().getPath().concat("/standard_fantastic.").concat(character.getImage().getExtension()));
            personaje.setURLImagen(character.getImage().getPath().concat("/portrait_uncanny.").concat(character.getImage().getExtension()));
            personajes.add(personaje);
        }
        return  personajes;
    }
}
