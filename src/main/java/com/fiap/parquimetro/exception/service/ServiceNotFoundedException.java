package com.fiap.parquimetro.exception.service;

public class ServiceNotFoundedException extends RuntimeException{

    public ServiceNotFoundedException(String message){
        super(message);
    }

}
