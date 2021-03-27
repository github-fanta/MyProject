package org.concurrent.c_006;

import java.util.concurrent.TimeUnit;

/**
 * 对业务写方法加锁
 * 对业务读方法不加锁
 * 容易产生脏读问题
 * @Author liq
 * @Date 2020/4/9
 */
public class Account {
    String name;
    double balance; // 余额

    // 写方法加锁  设置balance
    public synchronized void set(String name, double balance) {
        this.name = name;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.balance = balance;
    }

    // 读方法 不加锁  可能产生是脏读   要深入分析 临界资源最深入最后的变量，而不能仅仅停留在方法层面。
    public double getBalance(String name) {
        return this.balance;
    }

    public static void main(String[] args) {
        Account account = new Account();
        // 写方法加锁了
        new Thread(() -> account.set("zhangsan", 100.0)).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 读方法没加锁  导致脏读
        System.out.println(account.getBalance("zhangsan"));

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(account.getBalance("zhangsan"));
    }
}
