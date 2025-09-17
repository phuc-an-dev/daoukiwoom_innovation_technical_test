package com.example.daoukiwoom_innovation_technical_test.config;

import com.example.daoukiwoom_innovation_technical_test.constant.ApplicationResponseCode;
import com.example.daoukiwoom_innovation_technical_test.dto.response.ErrorApiResponse;
import com.example.daoukiwoom_innovation_technical_test.exception.ApplicationException;
import com.example.daoukiwoom_innovation_technical_test.exception.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class ApplicationExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleInValidMethodArgument(MethodArgumentNotValidException ex) {
        log.error(ex.getMessage());
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        Map.Entry<String, String> firstError = errors.entrySet().iterator().next();
        String firstErrorMessage = firstError != null ? firstError.getValue() : "Validation failed";
        log.error(firstErrorMessage);
        ErrorApiResponse<?> errorApiResponse = ErrorApiResponse.builder()
                .errorCode(ApplicationResponseCode.VALIDATION_ERROR)
                .message(firstErrorMessage)
                .errors(errors)
                .build();
        return ResponseEntity.badRequest().body(errorApiResponse);
    }

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<?> handleApplicationException(ApplicationException ex) {
        log.error(ex.getMessage());
        ErrorApiResponse<?> errorApiResponse = new ErrorApiResponse<>(ex);
        return ResponseEntity.badRequest().body(errorApiResponse);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleEntityNotFoundException(EntityNotFoundException ex) {
        log.error(ex.getMessage());
        ErrorApiResponse<?> errorApiResponse = new ErrorApiResponse<>(ex);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorApiResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex) {
        log.error(ex.getMessage());
        ErrorApiResponse<?> errorApiResponse = new ErrorApiResponse<>(ex.getMessage());
        return ResponseEntity.badRequest().body(errorApiResponse);
    }
}
