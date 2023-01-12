package com.shubham.orderservice.exception;

import org.springframework.http.HttpStatus;

public class CustomeException extends RuntimeException{
    private String errorCode;
    private int Status;

    public CustomeException(String message,String errorCode,int status){
     super(message);
        this.errorCode=errorCode;
     this.Status=status;
    }

}
