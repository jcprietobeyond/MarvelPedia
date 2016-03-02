package beyond.es.marvelpedia.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by BEYONDPC34 on 09/12/2015.
 */
public class Image {

    @JsonProperty(value = "path")
    String path;
    @JsonProperty(value = "extension")
    String extension;

    public Image() {}

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
