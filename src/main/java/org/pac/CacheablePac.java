package org.pac;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @Author liq
 * @Date 2020/3/13
 */
public class CacheablePac {

    public Trader getTrader(Trader trader) {
        return getTraderFromSql(trader.getName());
    }

    public Trader getTraderFromSql(String name) {
        // long time = System.currentTimeMillis();
        // if ((time & 0x1) == 1) {
        // name = "张三";
        // } else {
        // name = "hello";
        // }
        // System.out.println("===================== From SQL =====================");
        // return new Trader(name, "NewYork");
        // }
        System.out.println("===================== From SQL =====================");
        return new Trader("hello", "NewYork");
    }
}
