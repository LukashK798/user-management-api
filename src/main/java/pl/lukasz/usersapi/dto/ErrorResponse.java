package pl.lukasz.usersapi.dto;

import lombok.Data;

@Data
public class ErrorResponse {
    private int status;
    private String message;
}
