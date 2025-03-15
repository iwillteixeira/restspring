package br.com.springrest.springrest.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.springrest.springrest.exception.ExceptionResponse;
import br.com.springrest.springrest.exception.ResourceNotFoundException;

@RestController
@RestControllerAdvice
public class CustomEntityResponseHandler extends ResponseEntityExceptionHandler {

   @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse>handleAllExceptions(Exception ex, WebRequest request){
        ExceptionResponse response = new ExceptionResponse(
            new Date(), ex.getMessage(), request.getDescription(false));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ExceptionResponse>handleNotFoundExceptions(Exception ex, WebRequest request){
        ExceptionResponse response = new ExceptionResponse(
            new Date(), ex.getMessage(), request.getDescription(false));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
