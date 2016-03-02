package beyond.es.marvelpedia.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by BEYONDPC34 on 09/12/2015.
 */
public class CharacterDataContainer {

    @JsonProperty (value = "results")
    List<Character> results;

    public CharacterDataContainer(){

    }

    public List<Character> getResults() {
        return results;
    }

    public void setResults(List<Character> results) {
        this.results = results;
    }
}
