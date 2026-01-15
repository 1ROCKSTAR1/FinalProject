package api.models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonAlias;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmptyFieldResp {

    private Boolean success;
    private String error;
    private String message;

    @JsonAlias({"errors", "error"}) // Принимает оба варианта
    private Error errorDetails;

    @Data
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Error {
        private String message;
        private String param;
        private String value;
    }
}
