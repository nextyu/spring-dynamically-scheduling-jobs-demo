package com.nextyu.spring;

import com.nextyu.spring.task.DemoTask;
import com.nextyu.spring.task.DemoTask2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskConfig {

    @Bean
    public DemoTask demoTask() {
        return new DemoTask("111", "0/4 * * * * ?", "demoTask");
    }

    @Bean
    public DemoTask2 demoTask2() {
        return new DemoTask2("222", "0/8 * * * * ?", "demoTask2");
    }
}
