package com.qh.cloud.test.string;

import org.apache.poi.util.SystemOutLogger;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : QingHang
 * @version 1.0
 * @Description : TODO
 * @date : 2018/8/10 14:49
 */
public class Test {

    public static void main(String[] args) {
        sbTest();
    }

    public static void sbTest(){
        List<Integer>  list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        StringBuffer aud = new StringBuffer(" audit in ");
        StringBuffer sb = new StringBuffer();
        sb.append("(");
        for (Integer i : list){
            sb.append(i).append(",");
        }
        System.out.println(sb.toString());
       String sb1 = sb.substring(0,sb.length()-1);
        System.out.println(sb1);
        aud.append(sb1).append(")");
        System.out.println(aud.toString());
        System.out.println("========================");
        String address = "M509,46,M123,N6,N16,385,57,61,79,M105,N25,M389,B840等20条线路(清水河[公交站])";
        System.out.println("长度:"+address.length());
        System.out.println(address);
        address = address.substring(address.indexOf("(")+1,address.indexOf(")"));
        System.out.println(address);

        String endgps = " || ";
        if(endgps.contains("||")){
            String[] gpss = endgps.split("\\|\\|");
            endgps = gpss[0].trim();
        }
        System.out.println(endgps);

        System.out.println("===========================");

        String addr = "广东省深圳市宝安区 沙井镇上高坡南浦路140号";

        addr = addr.replaceAll(" +","");

        System.out.println("addr: "+ addr);
        System.out.println("===========================");


        String dddd = "深圳市福田区福华三路269号星河COCOParkB1(MO&Co.星河·CocoPark)";
        System.out.println("===length： "+ dddd.length());

        System.out.println("===========================");
        System.out.println("===========================");

        String timeQuantum = "2018-09-17 - 2018-09-19";
        String[] times = timeQuantum.split(" - ");

        System.out.println("===========================");

        String str = "6";

        int i = 6;
        System.out.println("========"+str.equals(String.valueOf(i)));



        System.out.println("===========================");


    }


}
