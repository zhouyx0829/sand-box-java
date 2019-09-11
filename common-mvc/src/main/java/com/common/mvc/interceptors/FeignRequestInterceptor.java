package com.common.mvc.interceptors;

import com.common.mvc.common.UnityAuthorize;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 忽略token拦截器，用作服务内部调用
 *
 * @author yx.zhou
 * @version 2019/3/2
 */
@ConfigurationProperties(prefix = "custom")
public class FeignRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        //请求header 中加上验证sign
        requestTemplate.header(UnityAuthorize.FEIGN_REQUESTH_HEADER, DigestUtils.sha256Hex(UnityAuthorize.paramsMapToString(requestTemplate.queries())));
    }
}
