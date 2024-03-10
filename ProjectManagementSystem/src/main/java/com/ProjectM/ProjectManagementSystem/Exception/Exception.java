package com.ProjectM.ProjectManagementSystem.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class Exception extends RuntimeException{

    public Exception(){

    }

    public Exception(String message){
        super(message);

    }
    public Exception(String message, Throwable throwable){
        super(message,throwable);
    }
}
