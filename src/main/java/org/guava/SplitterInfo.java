package org.guava;

import com.google.common.base.Splitter;
import com.google.common.base.Stopwatch;

import java.time.Duration;
import java.util.List;

/**
 * @Author liq
 * @Date 2020/3/20
 */
public class SplitterInfo {

    public static void main(String[] args) throws InterruptedException {
        List<String> strList = Splitter.on("|").omitEmptyStrings().trimResults().splitToList("str1 | str2 ||");

        // 等宽切分
        List<String> fixedStr = Splitter.fixedLength(4).splitToList("123412341234");

        // java
        // facebook
        // google#twitter#ebay
        List<String> limitStr = Splitter.on("#").limit(3).splitToList("java#facebook#google#twitter#ebay");


        List<String> patternSplit =
                Splitter.onPattern("\\|").trimResults().omitEmptyStrings().splitToList("str1 | str2 ||");
//        List<String> patternCompileSplit =
//                Splitter.on(Pattern.compile("\\|")).trimResults().omitEmptyStrings().splitToList("str1 | str2 ||");
//
//
//        Map<String, String> splitMap =
//                Splitter.on(Pattern.compile("\\|")).withKeyValueSeparator("=").split("k1=v1|k2= v2");

        Stopwatch stopwatch = Stopwatch.createStarted();
        stopwatch.elapsed().toString();
        Thread.sleep(1000);
        Duration elapsed = stopwatch.stop().elapsed();
        String time = elapsed.toString();


        return;
    }
}
