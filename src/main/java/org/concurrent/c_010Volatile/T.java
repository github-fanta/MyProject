package org.concurrent.c_010Volatile;

import java.util.concurrent.TimeUnit;

/**
 * volatile 比synchronized效率高很多，能用volatile可见性  就不要用synchronized  在JDK中用的很多。 “无锁同步”
 * @Author liq
 * @Date 2020/4/9
 */
public class T {
    // volatile: 如果值改变了，会通知其他地方的缓存值过期了
    /*volatile*/ boolean  running = true;
    // running在堆内存的t对象中，线程t1开始运行时，会把running值从内存中copy到t1线程的工作区，并不会内次都去读取堆内存， volatile强制线程所有线程都去堆内存中读取running
    // 单volatile 并不能保证多个线程共同修改running时 带来的不一致问题，也就是说 volatile(只保证可见性)不能替代synchronized(保证可见性，原子性)
    void m() {
        System.out.println("m start====");
        while(running) { // 线程会一直读加载到CPU缓存里的值，若其他线程修改了内存里面的值。而volatile变量会通知这里CPU缓存里的变量过期了，去内存再读新值

        }
        System.out.println("m end!");
    }

    public static void main(String[] args) {
        T t = new T();
        new Thread(t::m, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.running = false;
    }
}
