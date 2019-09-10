package com.qh.cloud.test.LongTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * @author : QingHang
 * @version 1.0
 * @Description : TODO
 * @date : 2019/7/23 18:05
 **/
public class Test {

    public static void main(String[] args) {

        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(3L);
        list.add(2L);
        list.add(10L);
        list.add(8L);

        System.out.println("========="+list);
        Long[] sss = new Long[list.size()];
        list.toArray(sss);
        System.out.println("========="+sss);

        BigDecimal defaultScore = BigDecimal.ZERO;

        BigDecimal dd = new BigDecimal("0");


        System.out.println("========="+list);


        long sid  = 30227731129241L;
        System.out.println(sid%8);




    }


}
