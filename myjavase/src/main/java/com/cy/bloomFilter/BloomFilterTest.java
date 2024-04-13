package com.cy.bloomFilter;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.Test;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class BloomFilterTest {

    @Test
   public void bloom1(){
        BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), 5000000);
        for (int i = 0; i < 5000000; i++) {
            bloomFilter.put(i);
        }
        long start = System.nanoTime();
        if (bloomFilter.mightContain(500000)) {
            System.out.println("成功过滤到500000");
        }
        long end = System.nanoTime();
        System.out.println("布隆过滤器消耗时间"+(end - start)/1000000L+"毫秒");

    }
    @Test
    public void bloom2(){
        BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8),5000000,0.01);
        List<String> list = new ArrayList<>(5000000);
        for (int i = 0; i < 5000000; i++) {
            String uuid = UUID.randomUUID().toString();
            bloomFilter.put(uuid);
            list.add(uuid);
        }
        int mightContainNumber1= 0;
        NumberFormat percentFormat = NumberFormat.getPercentInstance();
        percentFormat.setMaximumFractionDigits(2);

        for (int i=0;i < 500;i++){
            String key = list.get(i);
            if (bloomFilter.mightContain(key)){
                mightContainNumber1++;
            }
        }
        System.out.println("【key真实存在的情况】布隆过滤器认为存在的key值数：" + mightContainNumber1);
        System.out.println("================================================================================");
        int mightContainNumber2 = 0;
        for (int i=0;i < 5000000;i++){
            String key = UUID.randomUUID().toString();
            if (bloomFilter.mightContain(key)){
                mightContainNumber2++;
            }
        }

        System.out.println("【key不存在的情况】布隆过滤器认为存在的key值数：" + mightContainNumber2);
        System.out.println("【key不存在的情况】布隆过滤器的误判率为：" + percentFormat.format((float)mightContainNumber2 / 5000000));

    }
    @Test
    public void bloom3(){
        BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8),5000000,0.03);
        List<String> list = new ArrayList<>(5000000);
        for (int i = 0; i < 5000000; i++) {
            String uuid = UUID.randomUUID().toString();
            bloomFilter.put(uuid);
            list.add(uuid);
        }
        int mightContainNumber1= 0;
        NumberFormat percentFormat =NumberFormat.getPercentInstance();
        percentFormat.setMaximumFractionDigits(2);

        for (int i=0;i < 500;i++){
            String key = list.get(i);
            if (bloomFilter.mightContain(key)){
                mightContainNumber1++;
            }
        }

        System.out.println("【key真实存在的情况】布隆过滤器认为存在的key值数：" + mightContainNumber1);
        System.out.println("================================================================================");
        int mightContainNumber2 = 0;
        for (int i=0;i < 5000000;i++){
            String key = UUID.randomUUID().toString();
            if (bloomFilter.mightContain(key)){
                mightContainNumber2++;
            }
        }

        System.out.println("【key不存在的情况】布隆过滤器认为存在的key值数：" + mightContainNumber2);
        System.out.println("【key不存在的情况】布隆过滤器的误判率为：" + percentFormat.format((float)mightContainNumber2 / 5000000));

    }
    @Test
    public void bloom4(){
            BloomFilter<Integer> filter = BloomFilter.create(Funnels.integerFunnel(), 500, 0.01);
            // 判断指定元素是否存在
            System.out.println(filter.mightContain(1));
            System.out.println(filter.mightContain(2));
            // 将元素添加进布隆过滤器
            filter.put(1);
            filter.put(2);
            // 判断指定元素是否存在
            System.out.println(filter.mightContain(1));
            System.out.println(filter.mightContain(2));

    }
}
