package com.common.mvc.advice;

import com.common.mvc.model.Result;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 拦截Controller方法默认返回参数，统一处理返回值/响应体
 *
 * @author yx.zhou
 * @version 2019/3/2
 */
@ControllerAdvice
public class CustomerResponseBodyAdvice implements ResponseBodyAdvice<Object> {
    /**
     * 需要拦截的包
     */
    private String controllerPackage = "com.boottest";

    /**
     * 判断哪些需要拦截,false不拦截
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        String packageName = returnType.getMember().getDeclaringClass().getPackage().getName();
        return packageName.contains(controllerPackage);
    }

    /**
     * 返回的body 处理
     * 可以处理返回加密
     *
     * @param body
     * @param returnType
     * @param selectedContentType
     * @param selectedConverterType
     * @param request
     * @param response
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        Result result = new Result();
        result.setSuccess(true);
        result.setDate(body);
        if (returnType.getGenericParameterType().equals(String.class)) {
            response.getHeaders().set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
            try {
                return new ObjectMapper().writeValueAsString(result);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
