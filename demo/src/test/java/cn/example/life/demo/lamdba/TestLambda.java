package cn.example.life.demo.lamdba;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Junhuiji on 2018/2/6 9:49.
 */
@Slf4j
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class TestLambda {
    @Test
    public void RunnableTest() {
        log.info("====Runnable tst==========");
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                log.info("hello r1");
            }
        };
        Runnable r2 = () -> log.info("hello r2");
        r1.run();
        r2.run();

    }

    @Test
    public void lambdatest2() {
        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        for (String feature : features) {
            log.info(feature);
        }
        features.stream().forEach(result -> log.info("result:{}", result));
    }

    @Test
    public void lambdatest3() {
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp", "c");
        System.out.println("Languages which starts with J :");
        filter(languages, (str) -> str.startsWith("J"));

        System.out.println("Languages which ends with a ");
        filter(languages, (str) -> str.endsWith("a"));

        System.out.println("Print all languages :");
        filter(languages, (str) -> true);

        System.out.println("Print no language : ");
        filter(languages, (str) -> false);

        System.out.println("Print language whose length greater than 4:");
        filter(languages, (str) -> str.length() > 4);
        log.info("查询和C一样的字符串：");
        filter(languages, str -> str.equals("c"));
    }

    @Test
    public void lambdatest4() {
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp", "c");
        Predicate<String> startsWithJ = (n) -> n.startsWith("J");
        Predicate<String> fourLetterLong = (n) -> n.length() == 4;
        languages.stream()
                .filter(startsWithJ.and(fourLetterLong))
                .forEach((n) -> System.out.print("nName, which starts with 'J' and four letter long is : " + n));
    }

    @Test
    public void lambdatest5() {
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        for (Integer cost : costBeforeTax) {
            double price = cost + .12 * cost;
            log.info("price:{}", price);
        }
        costBeforeTax.stream().map(cost -> cost + .12 * cost).forEach(cost -> log.info("cost:{}", cost));
        double total = 0;
        for (Integer cost : costBeforeTax) {
            double price = cost + .12 * cost;
            total += price;
        }
        log.info("total:{}", total);
        total = costBeforeTax.stream().map(cost -> cost + .12 * cost).reduce((sum, cost) -> sum + cost).get();
        log.info("total:{}", total);
    }

    @Test
    public void lambdatest6() {
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp", "c");
        List<String> filtered = languages.stream().filter(lan -> lan.length() > 2).filter(lan -> lan.startsWith("J")).collect(Collectors.toList());
        log.info("filtered:{}", filtered);

        // 将字符串换成大写并用逗号链接起来
        List<String> sourceArr = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.", "Canada");
        String result = sourceArr.stream().map(str -> str.toUpperCase()).reduce((lastResult, str) -> lastResult + str + ",").get();
        log.info("result:{}", result);

        // 
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream().map(i -> i).distinct().collect(Collectors.toList());
        System.out.printf("Original List : %s,  Square Without duplicates : %s %n", numbers, distinct);
    }

    @Test
    public void lamdbtest7() {
        int count = 1000000;
        List<A> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(new A());
        }
        count = list.size();
        Long startTime = System.currentTimeMillis();
        List<A> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            A a = list.get(i);
            a.setId(1L);
            a.setName("name" + 1);
            result.add(a);
        }
        log.info("list info:{}",result.get(10));
        log.info("for :{}", (System.currentTimeMillis() - startTime) / (1000 * 0.1 * 60) + "秒");
        startTime = System.currentTimeMillis();
        List<A> result2 = list.stream().map(a -> {
            a.setId(1L);
            a.setName("name" + 1);
            return a;
        }).collect(Collectors.toList());
        log.info("list info:{}",result2.get(10));
        log.info("lambda test :{}", (System.currentTimeMillis() - startTime) / (1000 * 0.1 * 60) + "秒");
    }


    public void filter(List<String> names, Predicate<String> condition) {
        names.stream().filter(name -> condition.test(name)).forEach(name -> log.info("name:{}", name));
    }
}

@Slf4j
@ToString
class A {
    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    private String name;

    public A() {
    }

    public A(long id, String name) {
        this.id = id;
        this.name = name;
    }
}


