package com.tdb.tanbobo.main.entity;

import com.tdb.tanbobo.base.baen.BaseBean;

/**
 * @ClassName: SystemAccount
 * @Description: (这里用一句话描述这个类的作用)
 * @Author Tandingbo
 * @Date 2015/8/29 23:25
 */
public class SystemAccount extends BaseBean<SystemAccount> {

    /**
     * unid
     */
    private Integer unid;
    /**
     * uuid
     */
    private String uuid;

    public Integer getUnid() {
        return unid;
    }

    public void setUnid(Integer unid) {
        this.unid = unid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
