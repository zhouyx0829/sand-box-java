package com.common.mvc.advice;

import com.common.mvc.exception.AppException;
import com.common.mvc.exception.AuthorizationException;
import com.common.mvc.exception.Error;
import com.common.mvc.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yx.zhou
 * @version 2019/2/16
 */
@Slf4j
@ResponseBody
@ControllerAdvice
public class ExceptionControllerAdvice {

    /**
     * 通用异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(AppException.class)
    public Result appException(AppException ex) {
        return appExceptionToResult(ex);
    }

    /**
     * 授权异常
     *
     * @return
     */
    @ExceptionHandler(AuthorizationException.class)
    public Result authException() {
        return appExceptionToResult(new AppException(Error.UN_AUTHORIZATION));
    }

    public Result paramValidException() {
        return null;
    }


    private Result appExceptionToResult(AppException ex) {
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(ex.getCode());
        result.setMsg(ex.getMessage());
        return result;
    }
}
