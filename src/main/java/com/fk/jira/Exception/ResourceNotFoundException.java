package com.fk.jira.Exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException{

    String code;
    String reason;
    String message;

    public ResourceNotFoundException(String code, String reason, String message){
        super(message);
        this.code = code;
        this.reason = reason;
        this.message = message;
    }
}
