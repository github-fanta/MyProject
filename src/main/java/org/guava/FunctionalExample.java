package org.guava;

import javax.annotation.Nullable;

import com.google.common.base.Function;
import com.google.common.base.Functions;

/**
 * @Author liq
 * @Date 2020/3/20
 */
public class FunctionalExample {
    public static void main(String[] args) {
        // 先将第二个function执行完，再执行第一个funciton。func1: 传入String, 输出Integer; func2:传入Integer, 传出Double
        // 源码: return this.g.apply(this.f.apply(a))
        Function<String, Double> composeFunc = Functions.compose(new Function<Integer, Double>() {
            @Nullable @Override public Double apply(@Nullable Integer len) {
                return len * 2.0D;
            }
        }, new Function<String, Integer>() {
            @Nullable @Override public Integer apply(@Nullable String inputStr) {
                return inputStr.length();
            }
        });

        Double testStr = composeFunc.apply("testStr");

        // 类似于一个
        return;
    }
}

