package uz.bakhromjon.exception.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ValidationException extends RuntimeException {
    private String message;
    private final HttpStatus status = HttpStatus.BAD_REQUEST;

    public ValidationException(String message) {
        this.message = message;
    }
}
