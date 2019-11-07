package com.qh.cloud.test.arithmetic;

/**
 * @author : QingHang
 * @version 1.0
 * @Description : 归并排序
 * @date : 2019/11/5 20:53
 **/
public class MergeSort {


    public static void main(String[] args) {

        System.out.println("==========归并排序，写法=============");
        int[] numbers = { 22, 12, 88, 35, 64, 28, 50, 6 };
        print(numbers, "排序前");
        sort(numbers);
        print(numbers, "排序后");


    }


    /**
     * 递归
     * @param a
     */
    public static void sort(int[] a){

        int size = a.length;
        if(size <= 1){
            return;
        }
        mergeSort(a,0,size - 1);
    }

    /**
     * 递归调用
     * @param a
     * @param p
     * @param r
     */
    public static void mergeSort(int[] a,int p,int r){
        if(p >= r){
            return;
        }
        int z = (p + r)/2;
        mergeSort(a,p,z);
        mergeSort(a,z+1,r);
        merge(a,p,z,r);
    }

    /**
     * 数组的合并
     * @param a
     * @param p
     * @param q
     * @param r
     */
    public static void merge(int[] a,int p,int q,int r){

        int i = p ,j = q+1,k = 0;
        //临时数组
        int[] tmp = new int[r - p +1];
        while(i <= q && j <= r){
            if(a[i] <= a[j]){
                tmp[k++] = a[i++];
            }else{
                tmp[k++] = a[j++];
            }
        }
        //校验哪个区间还有剩余
        int s = i,e = q;
        if(j <= r){
            s = j;
            e = r;
        }
        //将剩余的copy到tmp中
        while(s<=e){
            tmp[k++] = a[s++];
        }
        //copy tmp到 原数组中
        for(int ii = 0; ii < k ;ii++){
            a[p+ii] = tmp[ii];
        }
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







//    /**
//     * 递归算法
//     * @param n
//     */
//    public static void sort(int[] n){
//        int size = n.length;
//        if(size <= 1){
//            return;
//        }
//        mergeSort(n,0,size - 1);
//    }
//
//    /**
//     * 递归调用
//     */
//    public static void mergeSort(int[] ar, int p,int r){
//        //递归的终止条件
//        if(p >= r){
//            return ;
//        }
//        int q = (p+r)/2;
//        mergeSort(ar,p,q);
//        mergeSort(ar,q + 1,r);
//        //将两个有序数组合并
//        merge(ar,p,q,r);
//    }
//
//    /**
//     * 合并两个数组
//     */
//    public static void merge(int[] ar,int p,int q,int r){
//
//        int i = p;
//        int j = q + 1 ;
//        int k = 0;
//        int[] tmp = new int[r-p+1];
//
//        while (i <= q && j <= r ){
//            if(ar[i] <= ar[j]){
//                tmp[k++] = ar[i++];
//            }else{
//                tmp[k++] = ar[j++];
//            }
//        }
//        int start = i;
//        int end = q;
//        if(j < r){
//            start = j;
//            end = r;
//        }
//
//        //将剩余的一个 copy到临时数组中去
//        while(start <= end){
//            tmp[k++] = ar[start++];
//        }
//
//        //将临时数组中的数据copy原数组中
//        for(int ii =0 ; ii <= r - p ; ii++){
//            ar[p+ii] = tmp[ii];
//        }
//    }
//
//




}
