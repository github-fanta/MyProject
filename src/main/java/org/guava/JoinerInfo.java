package org.guava;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.collect.ImmutableMap.of;

/**
 * @Author liq
 * @Date 2020/3/20
 *
 * Demos will be demoed by test case {@link JoinnerTest}
 */
public class JoinerInfo {

    private static List<String> strList =  Arrays.asList(
        "facebook", "google", "apple", "hello"
    );
    private static List<String> strListWithNull =  Arrays.asList(
        "facebook", "google", "apple", "hello", null
    );

    public static void main(String[] args) {
        String joinStr = Joiner.on("&").skipNulls().join(strListWithNull);
        String defaultVal = Joiner.on("&").useForNull("defaultVal").join(strListWithNull);

        // 写入文件、StringBuilder
        StringBuilder sBuilder = new StringBuilder();
        Joiner.on("&").appendTo(sBuilder, strList);

//        try (FileWriter writer = new FileWriter(new File("D://joiner.txt"))) {
//            Joiner.on("#").appendTo(writer, strList);
//        } catch (IOException e) {}

        // Java 流中的joining
        String streamJoin = strList.stream().collect(Collectors.joining("#"));

        // 万物皆可join——Map
        ImmutableMap<String, String> map = of("k1", "v1", "k2", "v2");
        String mapJoin = Joiner.on("#").withKeyValueSeparator("=").join(map);

        return;

    }
}
