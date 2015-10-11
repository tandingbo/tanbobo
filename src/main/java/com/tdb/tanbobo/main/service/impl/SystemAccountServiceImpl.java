package com.tdb.tanbobo.main.service.impl;

import com.tdb.tanbobo.main.dao.ISystemAccountDao;
import com.tdb.tanbobo.main.service.ISystemAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: SystemAccountServiceImpl
 * @Description: (这里用一句话描述这个类的作用)
 * @Author Tandingbo
 * @Date 2015/8/30 0:33
 */
@Service("systemAccountService")
public class SystemAccountServiceImpl implements ISystemAccountService {

    @Autowired
    private ISystemAccountDao systemAccountDao;

    @Override
    public List<Map<String, Object>> listMapAccount(Map<String, Object> params) {
        return systemAccountDao.listMapAccount(params);
    }
}
