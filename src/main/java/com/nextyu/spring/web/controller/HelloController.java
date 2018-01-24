package com.nextyu.spring.web.controller;

import cn.hutool.core.lang.Console;
import com.nextyu.spring.MyScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private MyScheduler scheduler;


    @GetMapping("/start")
    public Object go(String id, String cron) {


        scheduler.start(id, cron);

        return "success";
    }

    @GetMapping("/once")
    public Object once(String id) {
        scheduler.once(id);

        return "success";
    }

    @GetMapping("cancel")
    public Object cancel(String id) {
        scheduler.cancel(id);

        return "success";
    }

    @GetMapping("isRunning")
    public Object isRunning(String id) {
        Console.log("是否运行中：{}", scheduler.isRunning(id));

        return "success";
    }

}
