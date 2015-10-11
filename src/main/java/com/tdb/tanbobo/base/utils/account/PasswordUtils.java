package com.tdb.tanbobo.base.utils.account;

import com.tdb.tanbobo.base.utils.encrypt.md5.Md5Utils;

/**
 * @ClassName: PasswordUtils
 * @Description: (密码加密)
 * @Author Tandingbo
 * @Date 2015/8/31 22:04
 */
public class PasswordUtils {
    private static final String PREFIX = "83Yhds:><";
    private static final String SUFFIX = "k%$sdj628";

    public static String decode(String sourcePassword) {
        return Md5Utils.getMD5((PREFIX + sourcePassword + SUFFIX).getBytes());
    }

    public static void main(String[] args) {
        System.out.println(PasswordUtils.decode("123456"));
    }
}
