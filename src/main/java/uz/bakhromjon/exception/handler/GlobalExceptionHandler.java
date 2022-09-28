package uz.bakhromjon.exception.handler;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import uz.bakhromjon.exception.exception.UniversalException;
import uz.bakhromjon.exception.exception.ValidationException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UniversalException.class)
    public ResponseEntity<?> UniversalExceptionHandler(UniversalException exception, WebRequest webRequest) {
        return new ResponseEntity<>(exception.getMessage(), exception.getStatus());
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<?> ValidationExceptionHandler(ValidationException exception, WebRequest webRequest) {
        return new ResponseEntity<>(exception.getMessage(), exception.getStatus());
    }


}
