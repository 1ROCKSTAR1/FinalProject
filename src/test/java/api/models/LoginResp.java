package api.models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginResp {

        private Boolean success;
        private Data data;
        private String appVersion;

        @lombok.Data
        @NoArgsConstructor
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Data {
                private String id;

                @JsonProperty("apiToken")
                private String apiToken;

                @JsonProperty("newUser")
                private Boolean newUser;

                private String username;
        }
}

