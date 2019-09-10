package com.qh.cloud.test.baidumap;

import com.qh.cloud.test.http.HttpClient;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import test.SnCal;

/**
 * @author : QingHang
 * @version 1.0
 * @Description : TODO
 * @date : 2018/8/13 10:53
 */
public class BaiDuMapTest {


    static String ak = "TRKbXMFvZNe1i5sC0RGp2C7s2pb8t9j6";

    static String rul = "http://api.map.baidu.com/place/v2/search";

    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer(rul);

        //?query=市场&region=天津&output=json&ak=您的ak
        sb.append("?query=市场&region=天津&output=json");
        sb.append("&ak=");
        sb.append(ak);

        Map paramsMap = new LinkedHashMap<String, String>();
        paramsMap.put("query", "市场");
        paramsMap.put("region", "天津");
        paramsMap.put("output", "json");
        paramsMap.put("ak", ak);

        String res = HttpClient.httpClientGet(sb.toString());

        System.out.println(res);
        String ress =URLDecoder.decode(res);
        System.out.println(ress);

    }

}
