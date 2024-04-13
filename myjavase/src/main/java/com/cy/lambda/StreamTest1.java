package com.cy.lambda;

import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

/**
 * stream 集合-》创建流->中间操作-》终止操作(产生新流)
 */
public class StreamTest1 {

    @Test
    public  void test1(){
        List<String> list = Arrays.asList("23","hello","53","he55llo");
        list.forEach(System.out::println);

    }
    @Test
    public  void test2(){
//        终止操作：一次性执行全部内容--》“惰性求值”
        List<String> list = Arrays.asList("23","hello","53","he55llo");
        Stream<String> stream = list.stream();
        Stream<String> stream1 = Stream.of("23", "hello", "53", "he55llo");

//        stream.forEach(System.out::println);
        Stream<String> stream2 = stream.filter(x -> true);
        stream2.map(x->x.toUpperCase()).forEach(System.out::println);

    }

    @Test
    public  void test3(){
        List<String> list = Arrays.asList("23","hello","53","he55llo");
//比较排序
        Collections.sort(list,(o1, o2) -> o1.compareTo(o2));
//        遍历
        list.forEach(System.out::println);
        //    过滤
        list.stream().filter(s->s.length()>3).collect(toList()).forEach(System.out::println);
//        转换
        list.stream().map(s->s.length()).collect(toList()).forEach(System.out::println);
    }
    @Test
    public  void test4(){
        List<Integer> list = Arrays.asList(4,7,3,45,23,12);

//        累加 算法
        Optional<Integer> reduce = list.stream().reduce((a, b) -> a + b);
        System.out.println(reduce.get());
    }
    @Test
    public  void test5(){
        List<String> list = Arrays.asList("23","hello","53","he55llo");
//分组
        Map<Integer, List<String>> collect = list.stream().collect(groupingBy(String::length));
        System.out.println(collect);
        List<String> h = list.stream().filter(e -> e.startsWith("h")).map(String::toUpperCase).sorted().distinct().limit(1).collect(toList());
        System.out.println(h);
    }
}
