package org.concurrent.c_containerWarning;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * wait会释放锁，而notify 不会释放锁
 *
 * @Author liq
 * @Date 2020/4/10
 */
public class MyContainer_WaitAndNotify {
    volatile List list = new ArrayList<>();

    public static void main(String[] args) {
        MyContainer_WaitAndNotify container = new MyContainer_WaitAndNotify();

        final Object lock = new Object();

        // 一定要先执行wait
        new Thread(() -> {
            synchronized (lock) {
                System.out.println("t2执行");
                if (container.size() != 5) {
                    try {
                        lock.wait(); // 当前线程进入等待状态，同时释放锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2结束");
                lock.notify(); // notify 不会释放锁， 但是线程结束会自动释放锁。
            }
        }, "t2").start();

        new Thread(() -> {
            synchronized (lock) {
                System.out.println("t1启动");
                for (int i = 0; i < 10; i++) {
                    container.add(new Object());
                    System.out.println("add " + i);

                    if (container.size() == 5) {
                        lock.notify(); // notify是不会释放锁给线程t2的
                        // notify完了后  调用wait释放锁 让t2得以执行
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("t1结束");
        }, "t1").start();


    }

    public void add(Object o) {
        list.add(o);
    }

    public int size() {
        return list.size();
    }
}
