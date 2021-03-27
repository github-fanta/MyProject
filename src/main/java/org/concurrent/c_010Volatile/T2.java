package org.concurrent.c_010Volatile;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author liq
 * @Date 2020/4/9
 */
public class T2 {
    // volatile保证读的时候是最新的，可不保证你写回去的时候是最新的。即  只保证可见性，不保证原子性
    volatile int count = 0;
    void m() {
        for (int i = 0; i < 100; i++) {
            count ++;  // 可以用 AtomicInteger().incrementAndGet();
        }
    }

    public static void main(String[] args) {
        T2 t = new T2();

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(t::m, "thread-"+i));
        }
        threads.forEach((o) -> o.start());

        threads.forEach((o) -> {
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(t.count);
    }
}
