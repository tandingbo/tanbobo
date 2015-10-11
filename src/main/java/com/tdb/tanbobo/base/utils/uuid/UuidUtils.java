package com.tdb.tanbobo.base.utils.uuid;

import java.util.UUID;

/**
 * @ClassName: UuidUtils
 * @Description: (这里用一句话描述这个类的作用)
 * @Author Tandingbo
 * @Date 2015/8/31 22:16
 */
public class UuidUtils {
    public UuidUtils() {
    }

    public static String getUUID() {
        return  UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

    //获得指定数量的UUID
    public static String[] getUUID(int number) {
        if (number < 1) {
            return null;
        }
        String[] ss = new String[number];
        for (int i = 0; i < number; i++) {
            ss[i] = getUUID();
        }
        return ss;
    }

    public static void main(String[] args) {
        System.out.println(getUUID());
    }
}
