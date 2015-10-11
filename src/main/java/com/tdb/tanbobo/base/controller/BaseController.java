package com.tdb.tanbobo.base.controller;

import com.alibaba.fastjson.JSON;
import com.tdb.tanbobo.base.spring.security.CSRFTokenManager;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @ClassName: BaseController
 * @Description: (这里用一句话描述这个类的作用)
 * @Author Tandingbo
 * @Date 2015/8/29 23:20
 */
@Component
public class BaseController {

    /**
     * Spring MVC对于url的匹配采用的是一种叫做“最精确匹配的方式”
     * 1、首先我们定义一个拦截所有url的规则@RequestMapping("*")，那么实际上不存在找不到的页面了，也就是永远不会进入noHandlerFound方法体内
     * 2、其它请求都配置上@RequestMapping,那么请求过来，要么进入我们精确匹配的method（也就是找的到的），要么进入@RequestMapping("*)拦截的方法体内（也就是找不到的）
     * 3、让@RequestMapping("*)拦截的这个方法返回一个自定义的404界面
     *
     * @param request
     * @return
     */
    @RequestMapping("*")
    public ModelAndView all(HttpServletRequest request) {
        request.setAttribute("type", "404");
        request.setAttribute("content", "找不到匹配的资源！");
        return new ModelAndView("/errors/error");
    }

    public static HttpSession getSession() {
        HttpSession session = null;
        try {
            session = getRequest().getSession();
        } catch (Exception e) {
        }
        return session;
    }

    public static HttpServletRequest getRequest() {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attrs.getRequest();
    }

    /**
     * 日期转换器，这样就会作用到这个Controller里所有方法上
     *
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    /**
     * map转换为json格式
     *
     * @param result
     * @return
     */
    public String convertFastJson(Map<String, Object> result) {
        //将JsonObject数据转换为Json
        return JSON.toJSONString(result);
    }

    /**
     * 用于处理异常的
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
     * @return
     */
    @ExceptionHandler(Exception.class)
    public String operateExp(Exception ex, HttpServletRequest request) {
        request.setAttribute("type", "程序运行异常");
        request.setAttribute("content", ex.getMessage().toString());
        return "errors/error";
    }

    /**
     * 设置CSRF Token
     *
     * @return
     */
    protected String setCsrfToken() {
        String csrf = CSRFTokenManager.getTokenForSession(getSession());
        getSession().setAttribute(CSRFTokenManager.CSRF_TOKEN_FOR_SESSION_ATTR_NAME, csrf);
        return csrf;
    }

    /**
     * 验证CSRF Token
     *
     * @param CSRFToken
     * @return
     */
    protected boolean isValidCsrfToken(String CSRFToken) {
        if (CSRFToken == null || getSession().getAttribute(CSRFTokenManager.CSRF_TOKEN_FOR_SESSION_ATTR_NAME) == null || !CSRFToken.equals(getSession().getAttribute(CSRFTokenManager.CSRF_TOKEN_FOR_SESSION_ATTR_NAME).toString())) {
            return false;
        }
        return true;
    }

    /**
     * 验证AJAX请求CSRF Token
     *
     * @return
     */
    protected boolean isValidCsrfHeaderToken() {
        if (getRequest().getHeader("__RequestVerificationToken") == null
                || getSession().getAttribute(CSRFTokenManager.CSRF_TOKEN_FOR_SESSION_ATTR_NAME) == null
                || !this.getRequest().getHeader("__RequestVerificationToken").equals(getSession().getAttribute(CSRFTokenManager.CSRF_TOKEN_FOR_SESSION_ATTR_NAME).toString())
                ) {
            return false;
        }
        return true;
    }


}
