package com.qh.cloud.utils.timertask;

import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.qh.cloud.utils.DateUtils;

/**
 * 定时任务测试类
 * @author QingHang
 */
@Component
@PropertySource("classpath:properties/config.properties")
public class TeskJob {

	@Scheduled(cron = "${test.jobs.schedule}")
	public void testJob() {

		System.out.println("任务进行中。。。。。。" + DateUtils.getCurrentDate());
	}
}
