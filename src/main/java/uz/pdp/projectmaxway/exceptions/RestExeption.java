package uz.pdp.projectmaxway.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class RestExeption extends RuntimeException {
    private String message;
    private HttpStatus status=HttpStatus.BAD_REQUEST;

    private RestExeption(String message) {
        this.message=message;
    }

    private RestExeption(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public static RestExeption restThrow(String message) {
        return new RestExeption(message);
    }

    public static RestExeption restThrow(String message, HttpStatus status) {
        return new RestExeption(message, status);
    }
}
