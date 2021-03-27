package org.concurrent.c_009;

import java.util.concurrent.TimeUnit;

/**
 * synchronized 遇到异常 锁会被释放  所以并发时，小心发生不一致的情况 遇到异常要好好处理
 *
 * @Author liq
 * @Date 2020/4/9
 */
public class T {
    int count = 0;
    synchronized void m() {
        System.out.println(Thread.currentThread().getName() + " start");
        while (true) {
            count++;
            System.out.println(Thread.currentThread().getName() + " count = " + count);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (count == 5) {
                // 此处抛出异常， 锁将被释放，要想不被释放，可以在这里进行catch， 然后让循环继续
                int i = 1 / 0;
            }
        }
    }

    public static void main(String[] args) {
        T t = new T();
        Runnable r = new Runnable(){
            @Override
            public void run() {
                t.m();
            }
        };
        new Thread(r, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 线程1 抛异常后会释放锁，此时 t2就可以执行了。
        new Thread(r, "t2").start();
    }
}
