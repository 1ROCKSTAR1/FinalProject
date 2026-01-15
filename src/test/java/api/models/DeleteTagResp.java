package api.models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
public class DeleteTagResp {

    @JsonIgnoreProperties(ignoreUnknown = true)
    private Boolean success;
}
