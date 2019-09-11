package com.common.mvc.common;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yx.zhou
 * @version 2019/2/15
 */

public class UnityAuthorize {

    /**
     * 验证header的key
     */
    public static final String FEIGN_REQUESTH_HEADER = "feign_request_header";


    private static final String FEIGN_SIGN = "Mr.Zhou is so cool and handsome And I love acid :)";

    /**
     * 校验签名是否正确
     *
     * @param request
     * @param key
     * @return
     */
    public static boolean validRequest(HttpServletRequest request, String key) {
        return StringUtils.equals(key, signRequestParams(request));
    }

    public static String signRequestParams(HttpServletRequest request) {

        Map<String, Collection<String>> params = new HashMap<>(16);
        //request.getParameterMap()为只读,复制到新的map操作
        request.getParameterMap().forEach((k, v) -> params.put(k, Arrays.asList(v)));

        return DigestUtils.sha256Hex(paramsMapToString(params));
    }

    /**
     * 拼接字符串1:过滤空值 2:按照key升序排列 3:将参数key=value&首尾拼接 4:加上约定字符串
     *
     * @param params
     * @return
     */
    public static String paramsMapToString(Map<String, Collection<String>> params) {
        List<String> keys = new ArrayList<>(params.keySet());

        String content = params.entrySet().stream()
                //过滤空值
                .filter(entry -> Objects.nonNull(entry.getValue()))
                //按照key升序排列
                .sorted(Comparator.comparing(Map.Entry::getKey))
                //将参数key=value&首尾拼接
                .map(entry -> entry.getKey() + "=" + StringUtils.join(entry.getValue(), ","))
                .collect(Collectors.joining("&"));

        return content + "&" + FEIGN_SIGN;
    }
}
