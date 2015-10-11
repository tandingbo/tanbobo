package com.tdb.tanbobo.base.spring;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @ClassName: RequestFilter
 * @Description: (自定义过滤器filter实现对请求参数编解码)
 * @Author Tandingbo
 * @Date 2015/10/4 15:04
 */
public class RequestFilter extends OncePerRequestFilter {

    public String filter(HttpServletRequest request, String str) {
        String ret = str;
        //ios客户端请求参数值可能为(null)服务端过滤掉当null处理即可
        if (str == null || str.trim().equals("null")) {
            ret = null;
            return ret;
        }
        final String userAgent = request.getHeader("User-Agent");
        final String method = request.getMethod();
        //该处可以实现各种业务的自定义的过滤机制
        if (method.equalsIgnoreCase("get") || userAgent.toLowerCase().indexOf("android") != -1) {
            try {
                ret = new String(str.getBytes("ISO8859-1"), "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        filterChain.doFilter(new HttpServletRequestWrapper(httpServletRequest) {
            @Override
            public String getParameter(String name) {
                String value = super.getParameter(name);
                System.out.println("--------------------------"+value);
                return filter(this, value);
            }

            @Override
            public String[] getParameterValues(String name) {
                String[] values = super.getParameterValues(name);
                if (values == null) {
                    return null;
                }
                for (int i = 0; i < values.length; i++) {
                    values[i] = filter(this, values[i]);
                }
                return values;
            }
        }, httpServletResponse);
    }
}
