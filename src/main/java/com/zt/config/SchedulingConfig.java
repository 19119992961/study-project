package com.zt.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

/**
 * @Author: zt
 * @CreateTime: 2021/5/19 15:45
 * @描述：定时任务
 **/
@Configuration
@EnableScheduling
@EnableAsync
public class SchedulingConfig {
    @Value("${url.crawlingUrl}")
    private String crawlingUrl;


    @Async
    @Scheduled(cron = "${scheduled.crawlingTime}")  //间隔1秒
    public void first() throws InterruptedException {
        System.out.println(crawlingUrl);
        System.out.println("定时任务开始 : " + LocalDateTime.now().toLocalTime() + "\r\n线程 : " + Thread.currentThread().getName());
        Thread.sleep(1000 * 10);
    }
}
