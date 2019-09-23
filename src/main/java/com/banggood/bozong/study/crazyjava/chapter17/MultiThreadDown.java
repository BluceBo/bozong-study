package com.banggood.bozong.study.crazyjava.chapter17;

/**
 * @Author: admin
 * @Description:
 * @Date: 2018/7/3 22:49
 * @Modified By:
 * @Version: 1.0
 */
public class MultiThreadDown {
    public static void main(String[] args) {
        DownUtil downUtil = new DownUtil("http://p2.ifengimg.com/cmpp/2018/07/03/19/22670ae1-27e8-4c0a-b3be-b6c1edea99a0_size57_w608_h434.jpg","ios.jpg",4);
        //开始下载
        downUtil.download();
        //新增一个线程用于计算下载的进度
        new Thread(() -> {while (downUtil.getCompleteRate() < 1){
            System.out.println("已完成：" + downUtil.getCompleteRate());
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        }).start();
    }
}
