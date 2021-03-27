package org.concurrent.c_005;

/**
 * synchronized和非synchronized方法是否可以同时运行
 * @Author liq
 * @Date 2020/4/9
 */
public class T {
    public synchronized void m1() {
        System.out.println(Thread.currentThread().getName() + " m1 start.....");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m1 end");
    }

    public void m2() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m2");
    }

    public static void main(String[] args) {
        T t = new T();
        // 在t1执行synchronized方法m1期间  非synchronized方法m2是可以执行的。
        new Thread(() -> t.m1(), "t1").start();
        new Thread(() -> t.m2(), "t2").start();
    }
}
