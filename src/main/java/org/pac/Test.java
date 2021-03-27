package org.pac;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @Author liq
 * @Date 2019/12/31
 */

public class Test {

    public static void main(String[] args) {
        /**
         * 1.找出2011年发生的所有交易，并按交易额排序
         *
         * 2.交易员在哪些不同的城市工作过
         *
         * 3.查找所有来自剑桥的交易员，并按姓名排序
         *
         * 4.返回所有交易员的姓名字符串，并按字母顺序排序
         *
         * 5.有没有交易员在米兰工作的？
         *
         * 6.打印生活在剑桥的交易员的所有交易额
         *
         * 7.所有交易中，最高的交易额是多少
         *
         * 8.找到交易额最小的交易
         */

        //        Trader raoul = new Trader("Raoul", "Cambridge");
        //        Trader mario = new Trader("Mario", "Milan");
        //        Trader alan = new Trader("Alan", "Cambridge");
        //        Trader brian = new Trader("Brian", "Cambridge");
        //
        //        List<Transaction> transactions =
        //                Arrays.asList(new Transaction(brian, 2011, 300), new Transaction(raoul, 2012, 1000),
        //                        new Transaction(raoul, 2011, 400), new Transaction(mario, 2012, 1710),
        //                        new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));
        //
        //        // Query 1: Find all transactions from year 2011 and sort them by value (small to high).
        //        List<Transaction> list = transactions.stream().filter(t -> t.getYear() == 2011)
        //                .sorted(comparing(t -> t.getValue())).collect(toList());
        //        System.out.println(list);
        //
        //        // Query 2: What are all the unique cities where the traders work?
        //        List<Trader> uniqueCities = transactions.stream().map(Transaction::getTrader).distinct().collect(toList());
        //        System.out.println(uniqueCities);
        //
        //        // Query 3: Find all traders from Cambridge and sort them by name
        //        List<Trader> cambridgeTraders =
        //                transactions.stream().map(t -> t.getTrader()).filter(t -> t.getCity().equalsIgnoreCase("Cambridge"))
        //                        .sorted(comparing(t -> t.getName())).collect(toList());
        //        System.out.println(cambridgeTraders);
        //
        //        // Query 4: Return a string of all traders’ names sorted alphabetically.
        //        List<String> nameList =
        //                transactions.stream().map(t -> t.getTrader().getName()).distinct().sorted().collect(toList());
        //        System.out.println(nameList);
        //
        //        // Query 5: Are there any trader based in Milan?
        //        boolean isMilan = transactions.stream().anyMatch(t -> "milan".equalsIgnoreCase(t.getTrader().getCity()));
        //        System.out.println(isMilan);
        //
        //        // Query 6: Update all transactions so that the traders from Milan are set to Cambridge.
        //        System.out.println("set to Cambridge. Before: " + transactions);
        //        transactions.stream().map(Transaction::getTrader).filter(t -> "milan".equalsIgnoreCase(t.getCity()))
        //                .forEach(t -> t.setCity("Cambridge"));
        //        System.out.println("set to Cambridge. After: " + transactions);
        //
        //        // Query 7: What's the highest value in all the transactions?
        //        // int value = transactions.stream().max(comparing(Transaction::getValue)).get().getValue();
        //        // int value = transactions.stream().map(Transaction::getValue).reduce(0, Integer::max, (a, b) -> Math.max(a,
        //        // b));
        //        // IntSummaryStatistics summaryStatistics =
        //        // transactions.stream().mapToInt(Transaction::getValue).summaryStatistics();
        //        // int value = summaryStatistics.getMax();
        //
        //        int value = transactions.stream().collect(maxBy(comparing(Transaction::getValue))).get().getValue();
        //        System.out.println(value);
        //
        //
        //        ArrayList<Val> list2 = new ArrayList<>();
        //        list2.add(null);
        //
        //        Map<Integer, Val> map = list2.stream().filter(t -> t != null)
        //                .collect(groupingBy(Val::getIdx, collectingAndThen(maxBy(comparing(Val::getValue)), Optional::get)));
        //        System.out.println(map.size());
        //

        ArrayList<Student> list1 = new ArrayList<>();
        list1.add(new Student());
        ArrayList<Person> list3 = new ArrayList<>();
        list3.add(new Person());
        method(list1);
        method(list3);
    }

    public static  void method(ArrayList<?> list) {
        for (Object t : list) {
            System.out.println(t);
        }
    }

    static class Val {
        int idx;
        int value;

        public int getIdx() {
            return idx;
        }

        public void setIdx(int idx) {
            this.idx = idx;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

}
