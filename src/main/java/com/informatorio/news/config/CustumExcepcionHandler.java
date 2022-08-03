package com.informatorio.news.config;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustumExcepcionHandler extends ResponseEntityExceptionHandler {
    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                               HttpHeaders headers,
                                                               HttpStatus status,
                                                               WebRequest request) {
        ApiError error = new ApiError();
        error.setStatus(status);
        error.setMensaje("Validation Error");
        error.setCantidadDeErrores(ex.getErrorCount());
       List<ApiSubError> subErrors = ex.getBindingResult().getFieldErrors().stream().map(fieldError -> new ApiSubError(fieldError.getField(),fieldError.getDefaultMessage())).collect(Collectors.toList());
        error.setSubError(subErrors);
        return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
    }
}
