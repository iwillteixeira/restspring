package br.com.springrest.springrest.exception;

public class UnsupportedMathOperationException extends RuntimeException{

    public UnsupportedMathOperationException(String message){
        super(message);
    }
}
