# Spring 实现可动态配置的定时任务

很简单的一个demo

已实现：

- 取消任务
- 运行一次任务
- 动态修改cron表达式

## 第一步 

运行 SpringDynamicallySchedulingJobsDemoApplication.main() 方法

启动之后，打开控制台，你会发现有两个任务已经开始运行了，默认 demoTask 每4秒钟执行一次，demoTask2 每8秒钟执行一次。

```
名称：demoTask， 线程：taskScheduler-4，时间：2018-01-24 17-32-28，cron：0/4 * * * * ?
名称：demoTask， 线程：taskScheduler-3，时间：2018-01-24 17-32-32，cron：0/4 * * * * ?
名称：demoTask2， 线程：taskScheduler-8，时间：2018-01-24 17-32-32，cron：0/8 * * * * ?
```

## 第二步

打开浏览器：http://localhost:8888/test.html

页面写死了几个链接和参数，可以根据需要修改。

比如说点击了”取消“链接，可以在控制台看到，对应的任务不再运行。

## 第三步

如果需要开发自己的定时任务，只需要

1. 创建一个类继承 AbstractTask，再覆盖 run 方法。
2. 再把刚才新建的类配置到 TaskConfig 中。
3. 重启服务器。

