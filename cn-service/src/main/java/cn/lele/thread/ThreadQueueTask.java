package cn.lele.thread;


import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * spring多线程 使用
 * spring 启用线程池
 */
//多线程任务
@Component
public class ThreadQueueTask {

    @Resource
    private ThreadPoolTaskExecutor taskExecutor;

    @Resource
    private ThreadQueueIn threadQueueIn;

    @Resource
    private ThreadQueueOut threadQueueOut;

    @PostConstruct
    public void starThreadPoll(){
        taskExecutor.execute(threadQueueIn);
        taskExecutor.execute(threadQueueOut);
    }
}
