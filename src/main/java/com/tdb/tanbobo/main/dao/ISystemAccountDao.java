package com.tdb.tanbobo.main.dao;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: ISystemAccountDao
 * @Description: (这里用一句话描述这个类的作用)
 * @Author Tandingbo
 * @Date 2015/8/30 0:35
 */
public interface ISystemAccountDao {
    List<Map<String,Object>> listMapAccount(Map<String, Object> params);
}
