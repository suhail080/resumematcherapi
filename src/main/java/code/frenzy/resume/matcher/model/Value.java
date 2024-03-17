package code.frenzy.resume.matcher.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Value {

    @JsonProperty("@search.score")
    private float searchScore;
    private String content;

    @JsonProperty("metadata_storage_path")
    private String metaDataStoragePath;


}
