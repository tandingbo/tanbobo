package com.tdb.tanbobo.main.service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: ISystemAccountService
 * @Description: (这里用一句话描述这个类的作用)
 * @Author Tandingbo
 * @Date 2015/8/30 0:33
 */
public interface ISystemAccountService {
    List<Map<String,Object>> listMapAccount(Map<String, Object> params);
}
