package com.nextyu.spring;

import cn.hutool.core.util.ObjectUtil;
import com.nextyu.spring.task.AbstractTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;

@Component
public class MyScheduler {

    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    @Autowired
    private List<AbstractTask> tasks;

    private static final Map<String, Future> FUTURE_MAP = new ConcurrentHashMap<>();
    private static final Map<String, AbstractTask> TASK_MAP = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        for (AbstractTask task : tasks) {
            TASK_MAP.put(task.getId(), task);
            FUTURE_MAP.put(task.getId(), schedule(task));
        }
    }

    private Future<?> schedule(AbstractTask task) {
        return threadPoolTaskScheduler.schedule(task, new CronTrigger(task.getCron()));
    }

    public void start(String id, String cron) {
        AbstractTask existTask = TASK_MAP.get(id);
        existTask.setCron(cron);
        Future existFuture = FUTURE_MAP.put(id, schedule(existTask));
        if (ObjectUtil.isNotNull(existFuture)) {
            existFuture.cancel(false);
        }

    }

    public void once(String id) {
        threadPoolTaskScheduler.execute(TASK_MAP.get(id));
    }

    public void cancel(String id) {
        Future future = FUTURE_MAP.get(id);
        if (ObjectUtil.isNotNull(future)) {
            future.cancel(false);
        }
    }

    public boolean isRunning(String id) {
        Future future = FUTURE_MAP.get(id);
        return !future.isDone() && !future.isCancelled();
    }

}
