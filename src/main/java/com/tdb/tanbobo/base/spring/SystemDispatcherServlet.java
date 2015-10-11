package com.tdb.tanbobo.base.spring;

import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: SystemDispatcherServlet
 * @Description: (这里用一句话描述这个类的作用)
 * @Author Tandingbo
 * @Date 2015/10/4 19:57
 */
public class SystemDispatcherServlet extends DispatcherServlet {
    /**
     * ConversionNotSupportedException         500 (Internal Server Error)
     * HttpMediaTypeNotAcceptableException     406 (Not Acceptable)
     * HttpMediaTypeNotSupportedException      415 (Unsupported Media Type)
     * HttpMessageNotReadableException         400 (Bad Request)
     * HttpMessageNotWritableException         500 (Internal Server Error)
     * HttpRequestMethodNotSupportedException  405 (Method Not Allowed)
     * MissingServletRequestParameterException 400 (Bad Request)
     * NoSuchRequestHandlingMethodException    404 (Not Found)
     * TypeMismatchException                   400 (Bad Request)
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @return
     * @throws Exception
     */
    @Override
    protected ModelAndView processHandlerException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if (ex instanceof ConversionNotSupportedException) {
            request.setAttribute("type", "500");
            request.setAttribute("content", "服务器内部错误！");
            return new ModelAndView("/errors/error");
        } else if (ex instanceof HttpMessageNotWritableException) {
            request.setAttribute("type", "500");
            request.setAttribute("content", "服务器内部错误！");
            return new ModelAndView("/errors/error");
        } else if (ex instanceof HttpMediaTypeNotAcceptableException) {
            request.setAttribute("type", "406");
            request.setAttribute("content", "无和请求accept匹配的MIME类型！");
            return new ModelAndView("/errors/error");
        } else if (ex instanceof HttpRequestMethodNotSupportedException) {
            request.setAttribute("type", "405");
            request.setAttribute("content", "不支持此请求方法！");
            return new ModelAndView("/errors/error");
        } else if (ex instanceof NoSuchRequestHandlingMethodException) {
            request.setAttribute("type", "404");
            request.setAttribute("content", "找不到匹配的资源！");
            return new ModelAndView("/errors/error");
        } else if (ex instanceof HttpMessageNotReadableException) {
            request.setAttribute("type", "400");
            request.setAttribute("content", "无效请求链接！");
            return new ModelAndView("/errors/error");
        } else if (ex instanceof MissingServletRequestParameterException) {
            request.setAttribute("type", "400");
            request.setAttribute("content", "无效请求链接！");
            return new ModelAndView("/errors/error");
        } else if (ex instanceof TypeMismatchException) {
            request.setAttribute("type", "400");
            request.setAttribute("content", "无效请求链接！");
            return new ModelAndView("/errors/error");
        } else {
            return super.processHandlerException(request, response, handler, ex);
        }
    }
}
