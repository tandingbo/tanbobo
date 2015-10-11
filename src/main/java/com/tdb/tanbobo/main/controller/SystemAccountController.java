package com.tdb.tanbobo.main.controller;

import com.tdb.tanbobo.base.controller.BaseController;
import com.tdb.tanbobo.main.service.ISystemAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: SystemAccountController
 * @Description: (账户)
 * @Author tandingbo
 * @Date 2015/8/30 0:40
 */
@Controller
@RequestMapping("/account")
public class SystemAccountController extends BaseController {

    @Autowired
    private ISystemAccountService systemAccountService;

    /**
     * 列表账户信息
     *
     * @return
     */
    @RequestMapping(value = "/listMapPageAccount", method = RequestMethod.GET)
    public ModelAndView listMapAccount() {
        //查询参数集
        Map<String, Object> params = new HashMap<>();
        List<Map<String, Object>> listMapAccount = systemAccountService.listMapAccount(params);
        System.out.println(listMapAccount);

        //返回结果集
        Map<String, Object> model = new HashMap<>();
        model.put("listMap", listMapAccount);
        return new ModelAndView("account/account_list", model);
    }

    @RequestMapping(value = "/saveAccount", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> saveAccount(@RequestParam(value = "name", required = false) String name) throws Exception {
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("msg", "操作成功！");
        result.put("data", name);
        result.put("csrf", setCsrfToken());
        return result;
    }

    @RequestMapping(value = "/csrf", method = RequestMethod.GET)
    public String regionDel(@RequestParam String CSRFToken) throws Exception{
        System.out.println("CSRFToken:" + CSRFToken);
        if (!isValidCsrfToken(CSRFToken)) {
            throw new RuntimeException("无效请求链接！");
        }
        return "redirect:/region";
    }
}
