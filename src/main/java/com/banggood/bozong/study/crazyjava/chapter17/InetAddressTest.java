package com.banggood.bozong.study.crazyjava.chapter17;

import java.net.InetAddress;

/**
 * @Author: tanbo
 * @Description:
 * @Date: 2018/7/2 21:42
 * @Modified By:
 * @Version: 1.0
 */
public class InetAddressTest {
    public static void main(String[] args) throws Exception {
        //根据主机名来获取对应的InetAddress实例
        InetAddress ip = InetAddress.getByName("www.baidu.com");
        //判断是否可达
        System.out.println("百度是否可达：" + ip.isReachable(2000));
        //获取InetAddress实例的IP字符串
        System.out.println(ip.getHostAddress());
        //更具ip地址来获取对应的InetAddress实例
        InetAddress local = InetAddress.getByAddress(new byte[]{127, 0, 0, 1});
        System.out.println("本机是否可达：" + local.isReachable(2000));
        //获取该InetAddress实例对应的全限定域名
        System.out.println(local.getCanonicalHostName());
    }
}
