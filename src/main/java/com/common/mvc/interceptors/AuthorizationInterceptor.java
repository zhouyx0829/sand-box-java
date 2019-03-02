package com.common.mvc.interceptors;

import com.common.mvc.AuthorizationRealm;
import com.common.mvc.annotations.IgnoreToken;
import com.common.mvc.model.Subject;
import com.common.mvc.utils.UserControllerUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器 token
 *
 * @author yx.zhou
 * @version 2019/2/15
 */
@Slf4j
@ConfigurationProperties(prefix = "custom")
public class AuthorizationInterceptor implements HandlerInterceptor {

    /**
     * 进行拦截的包
     */
    private String controllerPackage = "com";

    final AuthorizationRealm authorizationRealm;

    public AuthorizationInterceptor(AuthorizationRealm authorizationRealm) {
        this.authorizationRealm = authorizationRealm;
    }

    /**
     * 该方法将在请求处理之前进行调用，只有该方法返回true，
     * 才会继续执行后续的Interceptor和Controller，
     * 当返回值为true 时就会继续调用下一个Interceptor的preHandle 方法，
     * 如果已经是最后一个Interceptor的时候就会是调用当前请求的Controller方法；
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (handler instanceof HandlerInterceptor && StringUtils.equals(HttpMethod.OPTIONS.name(), request.getMethod())) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Object bean = handlerMethod.getBean();
            Class<?> type = bean.getClass();
            //是否在拦截的包内
            if (type.getName().startsWith(controllerPackage)) {
                //如果有IgnoreToken注解则不拦截
                if (type.getAnnotation(IgnoreToken.class) != null || handlerMethod.getMethodAnnotation(IgnoreToken.class) != null) {
                    return true;
                }
                Subject<?> subject = authorizationRealm.authorization(request, handlerMethod);
                //取到了用户
                UserControllerUtils.setCurrentUser(subject);
            }
        }

        return false;
    }

    /**
     * 该方法将在请求处理之后，DispatcherServlet进行视图返回渲染之前进行调用，
     * 可以在这个方法中对Controller 处理之后的ModelAndView 对象进行操作。
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 该方法也是需要当前对应的Interceptor的preHandle方法的返回值为true时才会执行，
     * 该方法将在整个请求结束之后，也就是在DispatcherServlet 渲染了对应的视图之后执行。用于进行资源清理。
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
