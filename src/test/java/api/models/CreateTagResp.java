package api.models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateTagResp {

    private Boolean success;
    private TagData data;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TagData {
        private String id;
        private String name;

        private String challenge;
    }
}
