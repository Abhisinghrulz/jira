package com.fk.jira.Exception;

public enum ApiMessageEnum {

    RESOURCE_NOT_FOUND("Jira-001","resource.not.found","Resource not found");

    String code;
    String reason;
    String message;

    ApiMessageEnum(String code, String reason, String message) {
        this.code = code;
        this.reason = reason;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getReason() {
        return reason;
    }

    public String getMessage() {
        return message;
    }
}
