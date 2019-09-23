package com.banggood.bozong.study.bigdata.javabase.arichiver;

/**
 * 将int类型数字转换成二进制存放在byte数组中
 * @Author: tanbo
 * @Description:
 * @Date: Create in 17:24 2018/6/8
 * @Modified By:
 */
public class ArchiverUtil {
    /**
     * 将int类型数字存入字节数组中
     * @param length
     * @return
     */
    public static byte[] int2bytes(int length) {
        byte[] arr = new byte[4];
        arr[0] = (byte)length;
        arr[1] = (byte) (length >> 8);
        arr[2] = (byte) (length >> 16);
        arr[3] = (byte) (length >> 24);
        return arr;
    }

    /**
     * 将字节数组转换成int类型数字
     * @param arr
     * @return
     */
    public static int bytes2int(byte[] arr) {
        int i;
        int a = arr[0] & 0XFF;
        int b = (arr[1] & 0XFF) << 8;
        int c = (arr[2] & 0XFF) << 16;
        int d = (arr[3] & 0XFF) << 24;
        i = a | b | c | d;
        return i;
    }
}
