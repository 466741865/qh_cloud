package com.qh.cloud.test.dateTest;

import com.qh.cloud.utils.DateBuilder;

import java.util.Date;

/**
 * @author : QingHang
 * @version 1.0
 * @Description : TODO
 * @date : 2019/9/9 17:36
 **/
public class DateTest {


    public static void main(String[] args) {


        Date d = new Date();
        String time = DateBuilder.getCurrentDateSimple();

        Date ddd = DateBuilder.convertStringToDate(time+" 00:00:00",DateBuilder.YYYY_MM_DD_HHMMSS);

        //往后推三个小时
        Date endTime = DateBuilder.addHour(ddd,17);
        System.out.println("============="+ddd.before(d));
        System.out.println("============="+endTime.after(d));


        Date date = DateBuilder.convertStringToDate(time+" 00:00:00",DateBuilder.YYYY_MM_DD_HHMMSS);
        //往前推五分钟
        Date beginTime = DateBuilder.addMin(date,-5);
        System.out.println("============="+DateBuilder.convertDateToString(beginTime,DateBuilder.YYYY_MM_DD_HHMMSS));


    }


}
