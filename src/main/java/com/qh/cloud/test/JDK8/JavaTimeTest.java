package com.qh.cloud.test.JDK8;

import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

/**
 * @author : QingHang
 * @version 1.0
 * @Description : TODO
 * @date : 2018/12/4 21:22
 **/
public class JavaTimeTest {


    public static void main(String[] args) {

        Clock clock = Clock.systemDefaultZone();
        clock.millis();//等价于System.currentTimeMillis()

        System.out.println(ZoneId.getAvailableZoneIds());

        ZoneId zone1 = ZoneId.of("Brazil/East");
        System.out.println(zone1.getRules());


        LocalDate toDay = LocalDate.now();
        LocalDate tomorrow = toDay.plus(1, ChronoUnit.DAYS);



    }




}
