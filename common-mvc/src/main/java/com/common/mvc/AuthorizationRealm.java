package com.common.mvc;

import com.common.mvc.annotations.AuthorizationType;
import com.common.mvc.common.UnityAuthorize;
import com.common.mvc.exception.AppException;
import com.common.mvc.exception.AuthorizationException;
import com.common.mvc.exception.Error;
import com.common.mvc.model.DefaultSubject;
import com.common.mvc.model.Subject;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 授权实现
 *
 * @author yx.zhou
 * @version 2019/2/15
 */
public interface AuthorizationRealm {

    String AUTHORIZATION_HEADER = "Authorization";

    Map<String, AuthorizationRealm> AUTHORIZATION_REALM_MAP = new HashMap<>();

    /**
     * 用户登录校验
     *
     * @param request
     * @return
     * @throws AuthorizationException
     */
    Subject<?> login(HttpServletRequest request) throws AuthorizationException;

    /**
     * 授权校验
     *
     * @param request
     * @param method
     * @return
     * @throws AuthorizationException
     */
    default Subject<?> authorization(HttpServletRequest request, HandlerMethod method) throws AuthorizationException {
        try {
            //先判断 request的所有验证方式 ，如果抛出了异常，就用 feign 拦截器的验证方式
            AuthorizationType provider = method.getMethod().getAnnotation(AuthorizationType.class);
            if (provider == null) {
                //如果方法没有注解则看类有没有
                provider = method.getBean().getClass().getAnnotation(AuthorizationType.class);
            }
            if (provider == null) {
                return login(request);
            } else {

                String providerName = provider.value()[0];

                AuthorizationRealm authorizationRealm = AUTHORIZATION_REALM_MAP.get(providerName);
                if (authorizationRealm == null) {
                    throw new AppException(Error.NO_AUTHORIZATION_PROVIDER_FIND, providerName);
                }
                //校验登陆
                return authorizationRealm.login(request);
            }

        } catch (Exception e) {
            //拦截器验证,如果header中有
            String sign = request.getHeader(UnityAuthorize.FEIGN_REQUESTH_HEADER);

            if (StringUtils.isNotBlank(sign)) {
                //校验是否合法
                if (UnityAuthorize.validRequest(request, sign)) {
                    //内部用户，允许调用
                    return new DefaultSubject();
                } else {
                    //抛出异常
                    throw new AppException(Error.UN_AUTHORIZATION);
                }
            }
            throw e;
        }
    }


}
