package com.qh.cloud.test.arithmetic.search;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author : QingHang
 * @version 1.0
 * @Description : 二分查找
 * @date : 2019/11/11 20:43
 **/
public class BinaryTest {


    public static void main(String[] args) {

        System.out.println("========= 二分查找，写法=============");
        int[] numbers = { 5,14,18,21,35,40,46,50 };
        int c = sort(numbers,21);
        System.out.println("查找到的位置："+c);

        System.out.println("========= 二分查找--获取重复数组中k第一次出现的位置=============");
        int[] n1 = { 5,21,21,21,21,40,46,50 };
        int fc = binarySearchFirst(n1,21);
        System.out.println("获取重复数组中k第一次出现的位置=::查找到的位置："+fc);

        System.out.println("========= 二分查找--找出第一个大于等于给定值的元素=============");
        int[] n2 = { 5,21,21,21,21,40,46,50 };
        int fcc = binarySearchF(n2,20);
        System.out.println("找出第一个大于等于给定值的元素::查找到的位置："+fcc);

        System.out.println("========= 二分查找--求一个数的平方根：=============");
        BigDecimal dd = getSquareRoot(5);
        System.out.println("求一个数的平方根："+dd.doubleValue());


    }

    /**
     * 二分查找--普通写法
     * @param numbers
     */
    public static int  sort(int[] numbers,int k){
        if(numbers.length <=0){
            return -1;
        }
        int low = 0, high = numbers.length - 1;
        int mid = -1;
        while(low <= high){
            mid = low + ((high - low) >> 1);
            if(numbers[mid] > k){
                low = mid + 1;
            }else if(numbers[mid] < k){
                high = mid - 1;
            }else{
                return mid;
            }

        }
        return mid;
    }

    /**
     * 获取重复数组中k第一次出现的位置
     * @param numbers   5,21,21,21,21,40,46,50
     * @param k
     * @return
     */
    public static int binarySearchFirst(int[] numbers,int k){

        if(numbers.length <= 0 ){
            return -1;
        }
        int low = 0,high = numbers.length - 1;
        int mid = -1;

        while(low <= high){
            mid = low + ((high - low) >> 1);
            if(numbers[mid] == k) {
                if(mid == 0 || numbers[mid - 1] != k){
                    return mid;
                }else{
                    high = mid - 1;
                }
            } else if(numbers[mid] > k){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return mid;
    }


    /**
     * 找出第一个大于等于给定值的元素
     * @param numbers
     * @param k
     * @return
     */
    public static int binarySearchF(int[] numbers,int k){
        if(numbers.length <= 0 ){
            return -1;
        }
        int low = 0,heigh = numbers.length - 1;
        int mid = -1;
        while(low <= heigh){
            mid = low + ((heigh - low) >> 1);

            if(numbers[mid] >= k ){
                if(mid == 0 || numbers[mid - 1] < k){
                    return mid;
                }else{
                    heigh = mid - 1;
                }
            }else{
                low = mid + 1;
            }
        }

        return mid;
    }


    /**
     * 求一个数的平方根
     * @param x
     * @return
     */
    public static BigDecimal getSquareRoot(int x){
        BigDecimal min = BigDecimal.valueOf(0);
        BigDecimal max = BigDecimal.valueOf(x);
        BigDecimal half = BigDecimal.valueOf(-1);
        while (min.compareTo(max)<=0){
            half = (max.add(min)).divide(BigDecimal.valueOf(2),6, RoundingMode.HALF_UP);
            if (half.multiply(half).compareTo(BigDecimal.valueOf(x))<0){
                min = half.add(BigDecimal.valueOf(0.000001));
            }else {
                max = half.subtract(BigDecimal.valueOf(0.000001));
            }
        }
        return half;
    }




}
