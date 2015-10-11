package com.tdb.tanbobo.base.utils.account;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @ClassName: AccountUtils
 * @Description: (这里用一句话描述这个类的作用)
 * @Author Tandingbo
 * @Date 2015/8/31 22:05
 */
public class AccountUtils {
    private static AtomicLong atomicLong = new AtomicLong(0);
    private static final String PREFIX = "A";

    private static String getNextIndex() {
        long i = atomicLong.getAndIncrement();

        String str = "00" + i;
        return str.substring(str.length() - 3);
    }

    public static String getCustomerAccount() {
        StringBuilder sb = new StringBuilder();
        sb.append(PREFIX);
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMDDHHmmss");
        sb.append(format.format(new Date()));
        sb.append(getNextIndex());
        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println(getCustomerAccount());
    }
}
