package com.cy.lambda;

import com.google.common.base.Function;
import com.google.common.base.Supplier;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * 1、Lambda表达式由三部分组成：参数列表、方法体、返回类型
 * 2、函数式接口：定义一个接口(返回类型)，内部只有一个未实现的接口A(参数列表)，Lambda的方法体就会实现这个接口A(方法体)
 * 3、编译器根据上下文类型推导
 * 4、方法体中有变量是final的，如果是要修改，不能用基本数据类型，如int，可以用数字int[]或对象或参数等
 * <p>
 * <p>
 * 上联：左右遇一括号省
 * 下联：左侧推断类型省
 * 横批：能省则省
 */
public class LambdaYufa {

    @Test
    public void test1() {
        List<String> list = Arrays.asList("23", "hello", "53", "he55llo");
//        返回类型           参数列表            方法体
        Runnable runnable = () -> System.out.println("new Runnable");//        无参无返回
        Consumer consumer = (x) -> System.out.println(x);//有参无返回
        Consumer consumer2 = x -> System.out.println(x);//有参无返回  只有一个参数，省略括号
        Comparator<Integer> comparator = (x, y) -> {      //有2个参数以上用括号包起来，多条语句写在大括号里
            System.out.println(x);
            return Integer.compare(x, y);
        };
        Comparator<Integer> comparator2 = (x, y) -> Integer.compare(x, y);//有2个参数以上用括号包起来，只有一条语句,return 和大括号都可以不写，会自动推导
        Comparator<Integer> comparator3 = (Integer x, Integer y) -> Integer.compare(x, y);//参数制定类型
    }


    /**
     * 方法引用和对象引用
     * 若lambda体中的内容有方法已经实现了，我们可以使用方法引用
     */
    @Test
    public void test2() {
//        对象::实例方法名
//        需要注意的是接口的抽象方法的形参表，返回类型需要和调用类方法形参表 返回类型保持一致
        Consumer consumer2 = e -> System.out.println(e);
        consumer2.accept("consumer2");
        Consumer consumer = System.out::println;
        consumer.accept("consumer");

//        类::静态方法名
//        需要注意的是接口的抽象方法的形参表，返回类型需要和调用类方法形参表 返回类型保持一致

        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
        Comparator<Integer> comparator2 = Integer::compare;

        System.out.println(comparator.compare(4, 6));
        System.out.println(comparator2.compare(4, 6));

//        类：实例方法名
//        注意:第一个参数是实例方法的调用者，第二个参数是放到的传入参数
        Comparator<Integer> comparator3 = Integer::compareTo;
        System.out.println(comparator3.compare(6, 5));
    }

    /**
     * 构造器引用
     * 类::new   通过返回类型来推导调用那个构造函数
     */
    @Test
    public void test3(){

        Function<String, Person> stringPersonFunction = Person::new;
        Supplier<Person> stringPersonFunction1 = Person::new;
        Person person = stringPersonFunction1.get();


    }
}
