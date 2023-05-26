package flumine.sgm.auxilium.exceptions;


import flumine.sgm.auxilium.exceptions.validation.ValidationErrorResponse;
import flumine.sgm.auxilium.exceptions.validation.Violation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Path;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> catchBadTokenException (BadTokenException e) {
        return ResponseEntity.status(403).build();
    }

    @ExceptionHandler
    public ResponseEntity<?> catchResourceNotFoundException (ResourceNotFoundException e) {
        Map<String, AppError> str = new AppError(HttpStatus.NOT_FOUND.value(), e.getMessage()).toJSON();
        AppError appError = new AppError(HttpStatus.NOT_FOUND.value(), e.getMessage());
        return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(), e.getMessage()).toJSON(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<?> catchResourceAlreadyExistException (ResourceAlreadyExistException e) {
        return new ResponseEntity<>(new AppError(HttpStatus.UNPROCESSABLE_ENTITY.value(), e.getMessage()).toJSON(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler
    public ResponseEntity<?> catchUsernameNotFoundException (UsernameNotFoundException e) {

        return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(), e.getMessage()).toJSON(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<?> catchBadCredentialsException (BadCredentialsException e) {

        return new ResponseEntity<>(new AppError(HttpStatus.FORBIDDEN.value(), e.getMessage()).toJSON(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> onConstraintValidationException(
            MethodArgumentNotValidException e
    ) {

        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_GATEWAY);
    }



//        final List<Violation> violations = e.getConstraintViolations().stream()
//                .map(
//                        violation -> Violation.builder()
//                                .fieldName(violation.getPropertyPath().toString()
//                                        .substring(violation.getPropertyPath().toString().lastIndexOf(".") + 1))
//                                .message(violation.getMessage())
//                                .build()
//                )
//                .collect(Collectors.toList());
//        return new ResponseEntity<>(new ValidationErrorResponse(violations), HttpStatus.BAD_REQUEST);
//    }
}
