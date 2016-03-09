package beyond.es.marvelpedia.dto.model;

/**
 * Created by BEYONDPC34 on 02/12/2015.
 */
public class Personaje {
    private String nombre;
    private String descripcion;
    private String URLImagen;
    private String URLLogo;
    private Integer id;

    public Personaje(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Personaje() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setURLImagen(String URLImagen) {
        this.URLImagen = URLImagen;
    }

    public String getURLImagen() {
        return URLImagen;
    }

    public void setURLLogo(String URLLogo) {
        this.URLLogo = URLLogo;
    }

    public String getURLLogo() {
        return URLLogo;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
