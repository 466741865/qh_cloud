package com.qh.cloud.test.object;

/**
 * @author : QingHang
 * @version 1.0
 * @Description : TODO
 * @date : 2018/5/16 10:36
 */
public class CompareObjectTest {

    public static void main(String[] args) {

        User user1 = new User();
        user1.setId(1);
        user1.setName("lqh");
        user1.setAge(1);

        User user2 = new User();
        user2.setId(1);
        user2.setName("lqh");
        user2.setAge(1);
        user2.setSex(1);

        System.out.println("args = [" + user1.equals(user2) + "]");


        String oldName = "北京-会员-小面-01";
        String member= "非会员";
        String accountName = oldName.substring(0,oldName.indexOf("-")+1)+member+oldName.substring(oldName.indexOf("-",oldName.indexOf("-")+1),oldName.length());
        System.out.println("==");



    }
}
