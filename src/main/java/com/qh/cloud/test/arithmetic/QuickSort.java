package com.qh.cloud.test.arithmetic;

/**
 * @author : QingHang
 * @version 1.0
 * @Description : 快速排序
 * @date : 2019/11/6 13:07
 **/
public class QuickSort {


    public static void main(String[] args) {
        System.out.println("==========快速排序，写法=============");
        int[] numbers = { 22, 12, 88, 35, 64, 28, 50, 6 };
        print(numbers, "排序前");
        sort(numbers);
        print(numbers, "排序后");
    }


    public static void sort(int[] a){
        int size = a.length;

        if(size <= 1){
            return;
        }
        quickSort(a,0,size - 1);

    }


    /**
     * 快速排序
     * @param a
     * @param p
     * @param r
     */
    public static void quickSort(int[] a, int p ,int r){

        if(p >= r){
            return;
        }

        //查找q点位置
        int q = quick(a,p,r);

        quickSort(a,p,q - 1);
        quickSort(a,q + 1,r);
    }

    /**
     * 根据指针节点 ，进行排序
     * @param a
     * @param p
     * @param r
     * @return
     */
    public static int quick(int[] a,int p,int r){
        //设置比较点，每次均以最后一个节点作为比较点
        int z = a[r];
        //定义两个指针的位置，i是中心点指针，j是循环指针，起始位置都是p点
        int i = p,j = p ;
        for(;j < r; j++){
            if(a[j] < z){
                int tmp = a[j];
                a[j] = a[i];
                a[i] = tmp;
                i++;
            }
        }
        int t1 = a[r];
        a[r] = a[i];
        a[i] = t1;
        print(a, "排序中：");
        return i;
    }




    /**
     * @Description 打印数组
     */
    public static void print(int[] ints, String describe) {

        System.out.print("这是  " + describe + "  的数组:");
        System.out.print("[ ");
        for (int i : ints) {
            System.out.print(i + ",");
        }
        System.out.print(" ]");
        System.out.println();
    }


}
