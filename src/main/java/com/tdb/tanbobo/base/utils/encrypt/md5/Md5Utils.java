package com.tdb.tanbobo.base.utils.encrypt.md5;

/**
 * @ClassName: Md5Utils
 * @Description: (������һ�仰��������������)
 * @Author Tandingbo
 * @Date 2015/8/31 22:09
 */
public class Md5Utils {
    public static String getMD5(byte[] source) {
        String s = null;
        // �������ֽ�ת���� 16 ���Ʊ�ʾ���ַ�
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            md.update(source);
            byte tmp[] = md.digest();          // MD5 �ļ�������һ�� 128 λ�ĳ�������
            // ���ֽڱ�ʾ���� 16 ���ֽ�
            char str[] = new char[16 * 2];   // ÿ���ֽ��� 16 ���Ʊ�ʾ�Ļ���ʹ�������ַ���
            // ���Ա�ʾ�� 16 ������Ҫ 32 ���ַ�
            int k = 0;                                // ��ʾת������ж�Ӧ���ַ�λ��
            for (int i = 0; i < 16; i++) {          // �ӵ�һ���ֽڿ�ʼ���� MD5 ��ÿһ���ֽ�
                // ת���� 16 �����ַ���ת��
                byte byte0 = tmp[i];                 // ȡ�� i ���ֽ�
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];  // ȡ�ֽ��и� 4 λ������ת��,
                // >>> Ϊ�߼����ƣ�������λһ������
                str[k++] = hexDigits[byte0 & 0xf];            // ȡ�ֽ��е� 4 λ������ת��
            }
            s = new String(str);                                 // ����Ľ��ת��Ϊ�ַ���

        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
}
