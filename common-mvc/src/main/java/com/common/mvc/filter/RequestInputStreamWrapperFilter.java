package com.common.mvc.filter;

import com.common.mvc.entity.RepeatReadHttpServletRequestWrapper;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 确保在一次请求只通过一次filter，而不需要重复执行
 *
 * @author: yx.zhou
 * @Date: 2019/7/28
 * @Time: 21:44
 */
@WebFilter(urlPatterns = "/*")
@Component
public class RequestInputStreamWrapperFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 如果是json数据请求
        if ("application/json".equalsIgnoreCase(request.getContentType())) {
            RepeatReadHttpServletRequestWrapper requestWrapper = new RepeatReadHttpServletRequestWrapper(request);
            doFilter(requestWrapper, response, filterChain);
        } else {
            doFilter(request, response, filterChain);
        }
    }
}
