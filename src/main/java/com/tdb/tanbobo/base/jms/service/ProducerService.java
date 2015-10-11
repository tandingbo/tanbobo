package com.tdb.tanbobo.base.jms.service;

import javax.jms.Destination;

/**
 * @ClassName: ProducerService
 * @Description: (这里用一句话描述这个类的作用)
 * @Author Tandingbo
 * @Date 2015/10/11 15:27
 */
public interface ProducerService {
    void sendMessage(Destination destination, String s);
}
