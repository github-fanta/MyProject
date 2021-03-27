package org.guava;

import org.assertj.core.util.Preconditions;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @Author liq
 * @Date 2020/3/20
 */
public class PreconditionsInfo {


    public static void main(String[] args) {

        List<Integer> list = null;
        // 抛异常出来
        checkNotNull(list, "is null!!");
    }


}
