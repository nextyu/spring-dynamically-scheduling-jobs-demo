package com.nextyu.spring.task;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.lang.Console;
import com.nextyu.spring.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;


public class DemoTask extends AbstractTask {

    @Autowired
    private DemoService demoService;

    public DemoTask() {
    }

    public DemoTask(String id, String cron, String name) {
        super(id, cron, name);
    }

    @Override
    public void run() {
//        demoService.sayHi();
        Console.log("名称：{}， 线程：{}，时间：{}，cron：{}", getName(), Thread.currentThread().getName()
                , new DateTime().toString("yyyy-MM-dd HH-mm-ss"), getCron());
    }
}
