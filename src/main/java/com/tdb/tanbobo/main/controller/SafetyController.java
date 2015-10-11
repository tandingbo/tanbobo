package com.tdb.tanbobo.main.controller;

import com.tdb.tanbobo.base.controller.BaseController;
import com.tdb.tanbobo.base.utils.date.DateUtils;
import com.tdb.tanbobo.base.utils.uuid.UuidUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: SafetyController
 * @Description: (这里用一句话描述这个类的作用)
 * @Author Tandingbo
 * @Date 2015/8/29 23:24
 */
@Controller
@RequestMapping("/safety")
public class SafetyController extends BaseController {

    @RequestMapping("/singin")
    @ResponseBody
    public String singIn(
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "password", required = false) String password){

        Map<String, Object> result = new HashMap<>();
        if (StringUtils.isBlank(username)){
            result.put("status", "2");
            result.put("msg", "用户不能为空！");
            return convertFastJson(result);
        }
        if (StringUtils.isBlank(password)){
            result.put("status", "2");
            result.put("msg", "密码不能空！");
            return convertFastJson(result);
        }

        Map<String, Object> data = new HashMap<>();
        data.put("username", username);
        data.put("uid", UuidUtils.getUUID());
        data.put("token", UuidUtils.getUUID());
        data.put("avatarUrl", "sadfsadf");
        data.put("expiresTime", String.valueOf(DateUtils.getAfterMonthDate()));

        result.put("data", data);
        result.put("status", "1");
        return convertFastJson(result);
    }
}
