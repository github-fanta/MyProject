package org.guava;


import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Range;
import com.google.common.collect.Sets;
import com.google.common.collect.Table;

/**
 * @Author liq
 * @Date 2020/3/20
 */
public class CollectionsExample {
    public static void main(String[] args) {
        // 做笛卡尔积
        List<List<String>> lists = Lists.cartesianProduct(Lists.newArrayList("1", "2"), Lists.newArrayList("A", "B"));

        // transform 对list做操作
        List<String> originList = Lists.newArrayList("google", "facebook", "hello", "Java");
        Lists.transform(originList, String::toUpperCase).forEach(System.out::println);

        // partition：list一份为2.
        List<List<String>> partition = Lists.partition(originList, 2);

        /////////////////// SET///////////////////
        // Set, 好处是不用先new, 再add()
        HashSet<Integer> set = Sets.newHashSet(1, 2, 3);
        HashSet<String> strSet = Sets.newHashSet(originList);
        // set的笛卡尔积
        Set<List<Integer>> cartesianSet = Sets.cartesianProduct(set, Sets.newHashSet(4, 5, 6));
        // set内, 2个元素组合 set{1,2,3} [1,2] [1,3] [2,3]
        Set<Set<Integer>> combinations = Sets.combinations(set, 2);
        // 两个Set的差集 1,2,3 中去掉 3,2,6 得到 1.
        Sets.SetView<Integer> difference = Sets.difference(set, Sets.newHashSet(3, 2, 6));
        // 并集 1,2,3和3,2,6
        Sets.SetView<Integer> unionSet = Sets.union(set, Sets.newHashSet(3, 2, 6));

        /////////////////// Maps ///////////////////
        // List变Map
        List<String> valueList = Lists.newArrayList("1", "2", "3");
        // 不可变的map key是 k_key
        ImmutableMap<String, String> map = Maps.uniqueIndex(valueList, k -> k + "_key");
        // 可变的Map value是k_value
        Map<String, String> map2 = Maps.asMap(Sets.newHashSet("1", "2", "3"), v -> v + "_value");
        // 把map的所有key变成 指定的形式
        Map<String, String> newMap = Maps.transformValues(map, v -> v + "_transform");
        Map<String, String> filteredMap = Maps.filterKeys(map, k -> Sets.newHashSet("2_key", "3_key").contains(k));
        LinkedListMultimap<Integer, Integer> multipleMap = LinkedListMultimap.create();
        multipleMap.put(1, 1);
        multipleMap.put(1, 2);

        // BiMap key & value 都必须唯一。可以invers过来也正确
        HashBiMap<Integer, Integer> biMap = HashBiMap.create();
        biMap.put(1, 1);
        // biMap.put(1, 2); // can not do this!
        biMap.put(2, 3);
        // key变value value变key
        BiMap<Integer, Integer> inverseMap = biMap.inverse();

        // Table
        Table<String, String, String> table = HashBasedTable.create();
        table.put("row1", "col1", "1.2");
        table.put("row2", "col2", "2");
        table.put("row3", "col3", "3");
        table.put("row4", "col4", "4");
        Map<String, String> row1Map = table.row("row1");
        Map<String, String> col1Map = table.column("col1");
        // 拿到所有cell
        Set<Table.Cell<String, String, String>> cells = table.cellSet();

        /////////////////// Range ///////////////////
        // [1,9]
        Range<Integer> closedRange = Range.closed(0, 9);
        // true
        boolean closedContains9 = closedRange.contains(9);
        // 0
        Integer closedStart = closedRange.lowerEndpoint();
        // 9
        Integer closedEnd = closedRange.upperEndpoint();


        // (1,9)
        Range<Integer> openRange = Range.open(0, 9);
        // false
        boolean openContains9 = openRange.contains(9);
        // 0
        Integer openStart = openRange.lowerEndpoint();
        // 9
        Integer openEnd = openRange.upperEndpoint();

        // (1,9]
        Range<Integer> openClosedRange = Range.openClosed(0, 9);
        // false
        boolean openClosedContains0 = openClosedRange.contains(0);
        // true
        boolean openClosedContains9 = openClosedRange.contains(9);
        // 0
        Integer openClosedStart = openClosedRange.lowerEndpoint();
        // 9
        Integer openClosedEnd = openClosedRange.upperEndpoint();

        // [1,9)
        Range<Integer> closedOpenRange = Range.closedOpen(0, 9);

        return;

    }
}
