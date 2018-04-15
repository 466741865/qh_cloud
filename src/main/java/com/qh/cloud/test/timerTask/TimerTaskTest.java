package com.qh.cloud.test.timerTask;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.qh.cloud.utils.DateUtils;

/**
 * @Description 定时任务测试类
 * @Date 2017年9月11日 下午5:14:36
 * @author QingHang
 * @version 1.0.0
 */
@Component
// @PropertySource("classpath:properties/config.properties")
public class TimerTaskTest {

	@Scheduled(cron = "0 0/1 * * * ?")
	public void testJob() {

		System.out.println("任务进行中。。。。。。" + DateUtils.getCurrentDate());
	}
}
