package com.controlfood.interfaces.http.handler;

import com.controlfood.domain.errors.BusinessException;
import com.controlfood.domain.errors.ResourceNotFoundException;
import com.controlfood.interfaces.http.exceptions.ExceptionDetails;
import com.controlfood.interfaces.http.exceptions.ValidationExceptionDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionDetails> handleResourceNotFoundException(final ResourceNotFoundException resourceNotFoundException) {
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .details(resourceNotFoundException.getMessage())
                .title("Resource Not Found")
                .timestamp(LocalDateTime.now())
                .developerMessage(resourceNotFoundException.getClass().getName())
                .build();
        return ResponseEntity.status(404).body(exceptionDetails);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ExceptionDetails> handleBusinessException(final BusinessException businessException) {
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .status(HttpStatus.UNPROCESSABLE_ENTITY.value())
                .details(businessException.getMessage())
                .title("Business Exception")
                .timestamp(LocalDateTime.now())
                .developerMessage(businessException.getClass().getName())
                .build();
        return ResponseEntity.unprocessableEntity().body(exceptionDetails);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDetails> handleException(final Exception exception) {
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .details(exception.getMessage())
                .title("Internal Server Error")
                .timestamp(LocalDateTime.now())
                .developerMessage(exception.getClass().getName())
                .build();
        return ResponseEntity.internalServerError().body(exceptionDetails);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException methodArgumentNotValidException, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.info("Fields Error {}", methodArgumentNotValidException.getAllErrors());
        List<FieldError> fieldErrors = methodArgumentNotValidException.getBindingResult().getFieldErrors();
        Map<String, String> violations = getViolations(fieldErrors);
        ValidationExceptionDetails validationExceptionDetails = ValidationExceptionDetails.builder()
                .details("Check the wrong fields")
                .timestamp(LocalDateTime.now())
                .title("Field Validation Exception")
                .developerMessage(methodArgumentNotValidException.getClass().getName())
                .status(HttpStatus.BAD_REQUEST.value())
                .violations(violations)
                .build();
        return new ResponseEntity<>(validationExceptionDetails, HttpStatus.BAD_REQUEST);
    }

    private Map<String, String> getViolations(List<FieldError> fieldErrors) {
        Map<String, String> violations = new HashMap<>();
        for (FieldError fieldError : fieldErrors) {
            String field = fieldError.getField();
            String message = fieldError.getDefaultMessage();
            violations.put(field, message);
        }
        return violations;
    }
}
