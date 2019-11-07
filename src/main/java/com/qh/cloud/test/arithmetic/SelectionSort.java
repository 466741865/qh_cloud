package com.qh.cloud.test.arithmetic;

/**
 * @author : QingHang
 * @version 1.0
 * @Description : TODO
 * @date : 2019/10/31 19:55
 **/
public class SelectionSort {


    public static void main(String[] args) {

        System.out.println("==========选择排序，写法=============");
        Integer[] numbers = { 22, 12, 88, 35, 64, 28, 50, 6 };
        print(numbers, "排序前");
        sort(numbers);
        print(numbers, "排序后");
    }

    public static void sort(Integer[] n){
        int size = n.length;

        for (int i = 0; i < size ; i++){
            int min = i;
            for (int j = i + 1 ; j<size ;j++){
                if(n[min] >  n[j]){
                    min = j;
                }
            }
            if(min != i){
                int tmp = n[i];
                n[i] = n[min];
                n[min] = tmp;
            }
            print(n, "排序中" + i);
        }
    }

    /**
     * @Description 打印数组
     */
    public static void print(Integer[] ints, String describe) {

        System.out.print("这是  " + describe + "  的数组:");
        System.out.print("[ ");
        for (int i : ints) {
            System.out.print(i + ",");
        }
        System.out.print(" ]");
        System.out.println();
    }


}
