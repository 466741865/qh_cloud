package com.qh.cloud.test.arithmetic;

/**
 * @author : QingHang
 * @version 1.0
 * @Description : 插入排序
 * @date : 2019/10/31 12:58
 **/
public class InsertionSort {

    public static void main(String[] args) {

        System.out.println("==========插入排序，写法1=============");
        Integer[] numbers = { 22, 12, 88, 35, 64, 28, 50, 6 };
        print(numbers, "排序前");
        sort(numbers);
        print(numbers, "排序后");
    }
    public static void sort(Integer[] aa){

        int size = aa.length;
        if (size<=1){
            return;
        }
        for (int i = 1 ; i<size;i++){
            int v = aa[i];
            int j = i - 1;
            for (; j>=0;j--){
                if(aa[j] > v){
                    aa[j + 1] = aa[j];
                }else{
                    break;
                }
            }
            aa[j+1] = v;
            print(aa, "排序中"+i);
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
