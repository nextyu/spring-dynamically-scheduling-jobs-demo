package com.nextyu.spring.task;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class AbstractTask implements Runnable {

    private String id;

    private String cron;

    private String name;

    public AbstractTask() {
    }

    public AbstractTask(String id, String cron, String name) {
        this.id = id;
        this.cron = cron;
        this.name = name;
    }

    @Override
    public abstract void run();
}
