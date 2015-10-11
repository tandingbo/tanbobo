package com.tdb.tanbobo.main.controller;

import com.tdb.tanbobo.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName: SystemExceptionController
 * @Description: (这里用一句话描述这个类的作用)
 * @Author Tandingbo
 * @Date 2015/10/4 17:33
 */
@Controller
@RequestMapping("/error")
public class SystemExceptionController extends BaseController {

    @RequestMapping(value = "/403")
    public String Exception403() {
        return "errors/404";
    }

    @RequestMapping(value = "/404", method = RequestMethod.GET)
    public String Exception404() {
        return "errors/404";
    }

    @RequestMapping(value = "/405")
    public String Exception405() {
        return "errors/405";
    }

    @RequestMapping(value = "/500")
    public String Exception500() {
        return "errors/500";
    }

}
