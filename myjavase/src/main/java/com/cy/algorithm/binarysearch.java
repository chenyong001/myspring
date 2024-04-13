package com.cy.algorithm;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class binarysearch {
    @Test
    public void test() {
        int arr[] = {2, 423, 46, 7567, 223, 44, 66};
        int target =224;
        Arrays.sort(arr);
        String collect = Arrays.stream(arr).mapToObj(e->String.valueOf(e)).collect(Collectors.joining(","));
        System.out.println(collect);
        int index = binarysearch1( arr, target);
        int index2 = binarysearch2( arr, target);
        System.out.println(index );
        System.out.println(index2);

    }

    /**
     * 二分查找，复杂的未O(logn)
     *
     * @param arr
     * @param target
     * @return
     */
    private int binarysearch1(int[] arr, int target) {
        int lowIndex = 0;
        int highIndex = arr.length - 1;
        int mid = 0;
        while (lowIndex <= highIndex) {
            mid = (lowIndex + highIndex) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                lowIndex = mid + 1;
            }
            if (arr[mid] > target) {
                highIndex = mid - 1;

            }
        }
        return -1;
    }

    private int binarysearch2(int[] arr,int target){
        return binarysearch2(arr,target,0,arr.length-1);
    }
    private int binarysearch2(int[] arr,int target,int low,int high){
        if(low>high){
            return -1;
        }
        int mid = (low + high) / 2;
        if(arr[mid]==target){
            return mid;
        }
        if(arr[mid]<target){
            low=mid+1;
        }
        if(arr[mid]>target){
            high=mid-1;
        }
        return binarysearch2(arr,target,low,high);
    }
}
