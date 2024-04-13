package com.cy.algorithm;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;


public class Test1 {
    /**
     * 题意：就是问你火车出战的方案数。
     *
     * 分析：卡特兰数的模板题，递推公式：a[n]=a[n-1]*(4*n-2)/(n+1).
     * 1, 2, 5, 14, 42, 132, 429, 1430, 4862, 16796, 58786, 208012,
     */
    @Test
    public  void test1(){
        BigInteger a[] = new BigInteger[101];
        a[0] = BigInteger.ZERO;
        a[1] = BigInteger.ONE;
        for(int i=2;i<=100;i++) {
            a[i] = a[i-1].multiply(BigInteger.valueOf(4*i-2)).divide(BigInteger.valueOf(i+1));
        }
        System.out.println(a[5]);
        System.out.println(feibolaqi(6));
    }

    /**
     *  斐波那契数列又称为兔子数列,其数值为:1、1、2、3、5、8、13、21、34
     * @param n
     * @return
     */
    public int feibolaqi(int n){

        if(n==0||n==1){
           return 1;
        }
        return  feibolaqi(n-1)+feibolaqi(n-2);
    }
    @Test
    public void test3(){
        Integer amount=6;
        BigDecimal assetAmount=new BigDecimal("1280");
        BigDecimal divide = assetAmount.divide(new BigDecimal(amount),2, RoundingMode.HALF_UP);
        System.out.println(divide);
        System.out.println(divide.toString());
    }
}
