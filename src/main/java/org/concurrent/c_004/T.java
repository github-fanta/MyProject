package org.concurrent.c_004;

/**
 * 细致分析并发问题
 * @Author liq
 * @Date 2020/4/9
 */
public class T implements Runnable{
    private int count = 10;

    @Override
    public /*synchronized*/ void run() {  // 加上synchronized就好了
        count --; // 非原子减
        System.out.println(Thread.currentThread().getName() + " count = " + count);  // 减少和打印也非事务
    }

    public static void main(String[] args) {
        T t = new T();
        for (int i = 0; i < 5; i++) {
            new Thread(t, "THREAD" + i).start();  // 5个线程同时修改一个对象t的count变量
        }
    }
}
