package api.models;

import lombok.Data;

@Data
public class NonExistResp {

    private Boolean success;
    private String error;
    private String message;

}
