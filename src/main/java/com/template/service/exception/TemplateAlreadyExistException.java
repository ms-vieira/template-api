package com.template.service.exception;

import org.springframework.http.HttpStatus;

public class TemplateAlreadyExistException extends BusinessException {


    public TemplateAlreadyExistException() {
        super("templates-5", HttpStatus.BAD_REQUEST);
    }
}
