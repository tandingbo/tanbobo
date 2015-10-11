package com.tdb.tanbobo.main.dao.impl;

import com.tdb.tanbobo.main.dao.ISystemAccountDao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: SystemAccountDaoImpl
 * @Description: (这里用一句话描述这个类的作用)
 * @Author Tandingbo
 * @Date 2015/8/30 0:35
 */
@Repository("systemAccountDao")
public class SystemAccountDaoImpl extends SqlSessionTemplate implements ISystemAccountDao {

    @Autowired
    public SystemAccountDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public List<Map<String, Object>> listMapAccount(Map<String, Object> params) {
        return selectList("com.tdb.tanbobo.main.mapper.ISystemAccountMapper.selectMapList", params);
    }
}
