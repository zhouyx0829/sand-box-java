package com.common.mvc.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yx.zhou
 * @version 2019/2/16
 */
@Slf4j
public class ParamValidException extends Exception {

    private List<FieldError> fieldErrors = new ArrayList<>();


    public ParamValidException(MethodArgumentNotValidException e) {
        log.error("参数验证失败", e);
        fieldErrors = e.getBindingResult().getAllErrors()
                .stream()
                .map(error -> {
                    FieldError fieldError = new FieldError();
                    if (error instanceof org.springframework.validation.FieldError) {
                        org.springframework.validation.FieldError springError = (org.springframework.validation.FieldError) error;
                        fieldError.setName(springError.getField());
                    } else {
                        fieldError.setName(error.getObjectName());
                    }
                    fieldError.setMessage(error.getDefaultMessage());
                    return fieldError;
                }).collect(Collectors.toList());
    }



}
