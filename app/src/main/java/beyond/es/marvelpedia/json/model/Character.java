package beyond.es.marvelpedia.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by BEYONDPC34 on 09/12/2015.
 */
public class Character {

    @JsonProperty(value = "id")
    private Integer id;
    @JsonProperty(value = "name")
    private String nombre;
    @JsonProperty(value = "description")
    private String descripcion;
    @JsonProperty(value = "thumbnail")
    private Image image;

    public Character() {

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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
