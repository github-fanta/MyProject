package org.guava;

import com.google.common.base.CharMatcher;
import com.google.common.base.Strings;

import java.nio.charset.Charset;

/**
 * @Author liq
 * @Date 2020/3/20
 */
public class StringsInfo {
    public static void main(String[] args) {
        String nullStr = Strings.emptyToNull("");
        String emptyStr = Strings.nullToEmpty(null);
        String prefix = Strings.commonPrefix("hello", "her");
        String suffix = Strings.commonSuffix("hello", "elo");
        String repeatStr = Strings.repeat("123", 3);
        boolean nullOrEmpty = Strings.isNullOrEmpty("");
        String padString = Strings.padStart("abc", 5, 'P');
        String padEnd = Strings.padEnd("abc", 5, 'E');

        // 获取字符集
        Charset charset = Charset.forName("utf-8");

        // 字符是否是数字类型
        boolean isDigit = CharMatcher.javaDigit().matches('9');
        boolean isNotDigit = CharMatcher.javaDigit().matches('A');

        // 某给字符在String里面有几个
        int countChar = CharMatcher.is('A').countIn("Hello, my name is Liq, you can call me Alex! HAHAHAHA");

        // 一堆空格替只换成一个空格  A.collapseFrom("xxx", x)  表示从A操作从xxx里面执行。
        String relaceStr = CharMatcher.breakingWhitespace().collapseFrom("  Hello, world!   ", '@');

        // removeFrom & retainFrom
        // "abcdefg"
        String removeStr = CharMatcher.javaDigit().or(CharMatcher.whitespace()).removeFrom("abcd   1234  2 efg ");
        // "   1234  2 "
        String retaninStr = CharMatcher.javaDigit().or(CharMatcher.whitespace()).retainFrom("abcd   1234  2 efg ");

        return;
    }
}
