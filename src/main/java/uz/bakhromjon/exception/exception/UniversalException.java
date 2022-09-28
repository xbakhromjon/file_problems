package uz.bakhromjon.exception.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UniversalException extends RuntimeException {
    private String message;
    private HttpStatus status;

    public UniversalException(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }


}
