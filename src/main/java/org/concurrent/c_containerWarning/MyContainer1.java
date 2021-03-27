package org.concurrent.c_containerWarning;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 实现一个容器，提供2个方法 add,size
 * 写两个线程， 线程1添加10个元素到容器中，线程2实现监控元素的个数，当个数到5个时，线程2给出提示并结束
 * @Author liq
 * @Date 2020/4/10
 */
public class MyContainer1 {

    // 不加volatile的话  由于线程t1对myContainer1的修改对t2不可见，所以t2感知不到
    volatile List list = new ArrayList();

    public void add(Object o) {
        list.add(o);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        MyContainer1 myContainer1 = new MyContainer1();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                myContainer1.add(new Object());
                System.out.println("add " + i);

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t1结束");
        }, "t1").start();

        // 死循环太耗费cpu了 怎么解决？
        new Thread(() -> {
            while (true) {
                if (myContainer1.size() == 5) {
                    System.out.println("t2: 加入第五个了============");
                    break;
                }
            }
            System.out.println("t2结束");
        }, "t2").start();
    }
}
