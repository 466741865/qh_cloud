package com.qh.cloud.test.JDK8;

import java.lang.annotation.Repeatable;

/**
 * @author : QingHang
 * @version 1.0
 * @Description : TODO
 * @date : 2018/11/4 21:07
 **/
@Repeatable(RepeatedNotesaList.class)
@interface RepeatedNotesa {

        String name();
}


@interface RepeatedNotesaList{
    RepeatedNotesa[] value();
}

class RepeatedNotesaPerson{

    @RepeatedNotesa(name = "lqh")
    @RepeatedNotesa(name = "lqh")
    public void getSex(){}

}



