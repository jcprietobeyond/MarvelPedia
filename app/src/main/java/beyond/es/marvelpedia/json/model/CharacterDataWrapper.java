package beyond.es.marvelpedia.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by BEYONDPC34 on 09/12/2015.
 */
public class CharacterDataWrapper {

    @JsonProperty(value = "data")
    CharacterDataContainer data;

    public CharacterDataWrapper(){
    }

    public CharacterDataContainer getData() {
        return data;
    }

    public void setData(CharacterDataContainer data) {
        this.data = data;
    }
}
