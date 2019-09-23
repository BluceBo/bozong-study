package com.banggood.bozong.study.crazyjava.chapter7;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by admin on 2018/10/30.
 */
public class Arith {
    //默认除法运算精度
    private static final int DEF_DIV_SCALE = 10;
    //构造器私有该类不能实例化
    private Arith() {
    }
    //提供精确的加法运算
    public static double add(double v1,double v2) {
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.add(b2).doubleValue();
    }
    //提供精确的减法运算
    public static double sub(double v1,double v2) {
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.subtract(b2).doubleValue();
    }
    //提供精确的乘法运算
    public static double mul(double v1,double v2) {
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.multiply(b2).doubleValue();
    }
    //提供（相对）精确的除法当除不尽时保留小数点后10位四舍五入
    public static double div(double v1,double v2) {
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.divide(b2,DEF_DIV_SCALE, RoundingMode.HALF_UP).doubleValue();
    }
}
