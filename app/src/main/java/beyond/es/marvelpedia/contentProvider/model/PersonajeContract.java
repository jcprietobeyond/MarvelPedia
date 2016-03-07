package beyond.es.marvelpedia.contentProvider.model;

import android.provider.BaseColumns;

/**
 * Created by BEYONDPC34 on 03/03/2016.
 */
public class PersonajeContract {

    public static class PersonajeEntity implements BaseColumns {

        public static final String TABLE_NAME = "personaje";

        public static final String COLUMN_NAME = "nombre";
        public static final String COLUMN_DESCRIPCION = "descripcion";

    }
}
