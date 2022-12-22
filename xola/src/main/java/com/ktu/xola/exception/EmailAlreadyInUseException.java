package com.ktu.xola.exception;

public class EmailAlreadyInUseException extends Exception{
    @Override
    public String getMessage() {
        return "Email already used";
    }
}
