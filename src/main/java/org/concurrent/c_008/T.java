package org.concurrent.c_008;

import java.util.concurrent.TimeUnit;

/**
 * 子类中重入父类的方法 也是可以的
 * @Author liq
 * @Date 2020/4/9
 */
public class T {
    // 锁定this对象
    synchronized void m() {
        System.out.println("m start ===");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m end ===");
    }

    public static void main(String[] args) {
        new TT().m();
    }

    static class TT extends T{
        // 锁定this对象
       @Override
       synchronized void m() {
           System.out.println("child m start");
           super.m();
           System.out.println("child m end");
       }
    }
}
