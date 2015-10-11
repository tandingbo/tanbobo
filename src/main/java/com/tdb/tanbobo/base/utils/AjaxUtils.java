package com.tdb.tanbobo.base.utils;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @ClassName: AjaxUtils
 * @Description: (这里用一句话描述这个类的作用)
 * @Author Tandingbo
 * @Date 2015/10/4 16:07
 */
public class AjaxUtils {

    /**
     * 判断ajax请求
     *
     * @param request
     * @return
     */
    boolean isAjax(HttpServletRequest request) {
        return (request.getHeader("X-Requested-With") != null && "XMLHttpRequest".equals(request.getHeader("X-Requested-With").toString()));
    }

    public static void rendText(HttpServletResponse response, String content) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(content);
    }

    public static void rendJson(HttpServletResponse response, boolean success, String message) throws IOException {
        JSONObject json = new JSONObject();
        json.put("isSuccess", success);
        json.put("message", message);
        rendText(response, json.toString());
    }
}
