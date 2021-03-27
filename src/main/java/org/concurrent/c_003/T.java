package org.concurrent.c_003;

/**
 * @Author liq
 * @Date 2020/4/9
 */
public class T {
    private static int count = 10;

    // 锁定静态方法 等同于 synchronized(T.class)
    public synchronized static void m() {
        count --;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    // 和锁定this不同，这里不需要有对象存在。 不能用synchronized(this)替换
    public static void mm() {
        synchronized (T.class) {
            count --;
        }
    }
}
