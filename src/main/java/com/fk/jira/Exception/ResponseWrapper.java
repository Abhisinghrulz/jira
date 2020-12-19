package com.fk.jira.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class ResponseWrapper{
    String code;
    String reason;
    String message;


}
