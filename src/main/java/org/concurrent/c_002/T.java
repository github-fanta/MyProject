package org.concurrent.c_002;

/**
 * @Author liq
 * @Date 2020/4/9
 */
public class T {
    private int count = 10;

    public void m1() {
        // synchronized锁的不是代码块 锁的是对象。 本例锁定当前对象
        synchronized (this) {
            count--;
            System.out.println(Thread.currentThread().getName() + "count = " + count);
        }
    }

    // 等价于下面写法
    public synchronized void m2() {
        // synchronized锁的不是代码块 锁的是对象。
        count--;
        System.out.println(Thread.currentThread().getName() + "count = " + count);
    }
}
