package beyond.es.marvelpedia.dao.generator;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;
import de.greenrobot.daogenerator.ToMany;
import de.greenrobot.daogenerator.ToOne;

public class GeneratorMain {

    public static final void main(String arg[]) throws Exception {
        Schema schema = new Schema(2, "beyond.es.marvelpedia.modelo");
        Entity personajeEntity = crearPersonaje(schema);
        Entity comicEntity = crearComic(schema);

        Property personajeIdInComic = comicEntity.addLongProperty("personajeId").columnName("personaje_id").notNull().getProperty();
        ToOne ComicToPersonaje = comicEntity.addToOne(personajeEntity, personajeIdInComic);
        ToMany PersonajeToComic = personajeEntity.addToMany(comicEntity, personajeIdInComic);

        new DaoGenerator().generateAll(schema, "../app/src/main/java");
    }

    private static Entity crearComic(Schema schema) {
        Entity comicEntity = schema.addEntity("Comic");
        comicEntity.addIdProperty().notNull().index().unique();
        comicEntity.addStringProperty("titulo");
        comicEntity.addStringProperty("descripcion");
        return comicEntity;
    }

    private static Entity crearPersonaje(Schema schema) {
        Entity personajeEntity = schema.addEntity("Personaje");
        personajeEntity.addIdProperty().notNull().index().unique();
        personajeEntity.addStringProperty("nombre").notNull();
        personajeEntity.addStringProperty("descripcion");
        personajeEntity.addStringProperty("URLImagen").columnName("url_imagen");
        personajeEntity.addStringProperty("URLLogo").columnName("url_logo");
        personajeEntity.addDateProperty("fechaNacimiento").columnName("fecha_nacimiento");
        return personajeEntity;
    }
}
