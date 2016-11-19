package cn.lele.thread;

/**
 * Created by liu on 16-11-19.
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 定义spring线程池
 */
//线程配置
@Configuration
public class ThreadConfiguration {
    /**
     * spring的线程池
     */
    @Bean
    public ThreadPoolTaskExecutor taskExecutor(){
        ThreadPoolTaskExecutor tpte = new ThreadPoolTaskExecutor();
        //活动线程
        tpte.setCorePoolSize(3);
        //最大线程
        tpte.setMaxPoolSize(5);
        //等待任务完成在关闭
        tpte.setWaitForTasksToCompleteOnShutdown(true);
        return tpte;
    }
    /**
     * 定义队列bean
     */
    //阻塞线程
    @Bean
    public BlockingQueue blockingQueue(){

        BlockingQueue blockingQueue = new LinkedBlockingQueue(10000);

        return blockingQueue;
    }
}
