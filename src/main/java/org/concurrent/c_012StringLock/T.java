package org.concurrent.c_012StringLock;

/**
 * 不要用字符串常量作为锁定对象
 * @Author liq
 * @Date 2020/4/9
 */
public class T {
    // s1和s2其实是同一个对象。   如果s1在一个类库源码很深处，读不到源码，就会和源码不经意间使用了同一把锁，发生非常诡异的死锁阻塞
    // 在Jetty内原来发生过这个Bug
    String s1 = "hello";
    String s2 = "hello";

    void m1() {
        synchronized (s1) {

        }
    }

    void m2() {
        synchronized (s2) {

        }
    }
}
