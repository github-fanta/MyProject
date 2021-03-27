package org.concurrent.c_007;

import java.util.concurrent.TimeUnit;

/**
 * 同步方法调用另一个同步方法，一个线程已经拥有某个对象的锁，再次申请的时候仍然会得到该对象的锁。
 * 也就是说synchronized获得的锁是可重入的。
 * 线程互相通讯，两种模型：1.大家都去读共享内存(Java使用)  2.线程之间互相发消息。
 * @Author liq
 * @Date 2020/4/9
 */
public class T {

    synchronized void m1() {
        System.out.println("m1 start....");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 调用另一个同步方法
        m2();
    }

    synchronized void m2() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2");
    }
}
