package cn.lele.thread;

/**
 * Created by liu on 16-11-19.
 */

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.BlockingQueue;

/**
 * 入队列线程
 */
//线程队列入
@Component
public class ThreadQueueIn implements Runnable {

    @Resource
    private BlockingQueue<String> blockingQueue;

    public void run() {
        int conut = 0;
        for (;;){
            blockingQueue.offer(conut + ":消息-->blockingQueue");

            conut++;
        }
    }
}
