package com.common.mvc.exception;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.validation.ConstraintViolationException;
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
        log.error("参数验证失败e->{}", e);
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

    /**
     * 组装message
     *
     * @return
     */
    @Override
    public String getMessage() {
        StringBuilder sb = new StringBuilder();
        fieldErrors.forEach(fieldError -> {
            sb.append(fieldError.toString());
            sb.append("\n");
        });

        return sb.toString();
    }


    public ParamValidException(ConstraintViolationException e, MethodParameter[] methodParameters) {

        this.fieldErrors = e.getConstraintViolations().stream()
            .map(constraintViolation -> {
                PathImpl path = (PathImpl) constraintViolation.getPropertyPath();
                int paramIndex = path.getLeafNode().getParameterIndex();
                String paramName = methodParameters[paramIndex].getParameterName();
                FieldError error = new FieldError();
                error.setName(paramName);
                error.setMessage(constraintViolation.getMessage());
                return error;
            })
            .collect(Collectors.toList());
    }

    public ParamValidException(List<FieldError> errors) {
        this.fieldErrors = errors;

    }
}
